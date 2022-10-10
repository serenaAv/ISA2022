/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertLinks {

	public static void main(String args[]) {
		  
		String url = "jdbc:db2://localhost:25001/c2c";
		Connection con;
		Statement stmt;
		String query = "select DESTINATION, DAY, TIME_ARR_PREV from LINKS";
	
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
	
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}	
	
		try {
			con = DriverManager.getConnection(url,"db2admin","serena");
	
			stmt = con.createStatement();							
	
			stmt.executeUpdate("insert into LINKS " +
	                 "values(1, 'Berlino', '2020-01-01', '10.45.00', '16.00.00')");
		
			stmt.executeUpdate("insert into LINKS " +
	                 "values(2, 'Amsterdam', '2020-06-01', '08.45.00', '18.00.00')");
	
			stmt.executeUpdate("insert into LINKS " +
	                 "values(3, 'Barcellona', '2021-09-15', '9.45.00', '16.30.00')");
			
			stmt.executeUpdate("insert into LINKS " +
	                 "values(4, 'Vienna', '2020-11-13', '12.30.00', '16.15.00')");
			
			stmt.executeUpdate("insert into LINKS " +
	                 "values(5, 'Parigi', '2022-03-28', '16.45.00', '23.50.00')");
	
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Collegamenti offerti da City2City: date e orari presunti");
			while (rs.next()) {
				String d = rs.getString("DESTINATION");
				Date g = rs.getDate("DAY");
				Time h= rs.getTime("TIME_ARR_PREV");
				System.out.println(d + ", " + g + " ore " + h);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

