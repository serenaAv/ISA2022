/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 


import java.sql.*;
     
public class UpdateBusRev {

	public static void main(String args[]) {
		String url = "jdbc:db2://localhost:25001/c2c";
	        
		Connection con;
		String updateString;
		
		updateString = "UPDATE BUS SET DATE_LAST_REV = '2022-04-15'"+
		"WHERE PLATE like 'AA123QW'";
		
		Statement stmt;
		String query = "select PLATE, YEAR, DATE_LAST_REV from BUS where PLATE like 'AA123QW'"; 
	
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url,"db2admin","serena");
	
			stmt = con.createStatement();							
	   		stmt.executeUpdate(updateString); 
	   		
	   		ResultSet rs = stmt.executeQuery(query);
	   		
			System.out.println("Codice della prenotazione, data e id cliente");
			while (rs.next()) {
				String pl = rs.getString("PLATE");
				int ye = rs.getInt("YEAR");
				Date lr=rs.getDate("DATE_LAST_REV");
				System.out.println(pl + ": anno di immatricolazione " + ye + ", data ultima revisione: "+ lr);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

