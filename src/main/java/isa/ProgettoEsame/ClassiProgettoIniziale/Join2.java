package isa.ProgettoEsame.ClassiProgettoIniziale;
/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class Join2 {

	public static void main(String args[]) {
		  
		String url = "jdbc:db2://localhost:25001/c2c";

		Connection con;
		String query = "select TRAVELS.TRAV_ID, TRAVELS.DATE " +
					   "from TRAVELS, CUSTOMERS, BOOKS " +
					   "where CUSTOMERS.ID_CUST= BOOKS.ID_CUST and TRAVELS.TRAV_ID = BOOKS.TRAV_ID AND CUSTOMERS.ID_CUST = 1";
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
			System.out.println("Viaggi del cliente");
			
			while (rs.next()) {
				String TI = rs.getString("TRAV_ID");
				Date DA = rs.getDate("DATE");
				System.out.println("Codice viaggio: " + TI + ", data "+ DA);
			}
			

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}	
	}
}

