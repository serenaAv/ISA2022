/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class Join {

	public static void main(String args[]) {
		  
		String url = "jdbc:db2://localhost:25001/c2c";

		Connection con;
		String query = "select distinct BUS.ID_BUS, BUS.PLATE, BUS.YEAR " +
					   "from TRAVELS, BUS " +
					   "where TRAVELS.ID_BUS = BUS.ID_BUS and TRAVELS.N_PASS <= 30";
		Statement stmt;
	
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
	
		try {
			con = DriverManager.getConnection(url,"db2admin","serena");
	
			stmt = con.createStatement();							
	
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Bus che hanno trasportato meno di 30 passeggeri");
			
			while (rs.next()) {
				int IB = rs.getInt("ID_BUS");
				String BP = rs.getString("PLATE");
				int BY = rs.getInt("YEAR");
				System.out.println(IB + " " + BP + " "+ BY);
			}
			

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}	
	}
}

