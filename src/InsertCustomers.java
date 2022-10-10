/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertCustomers {

	public static void main(String args[]) {
		  
		
		String url = "jdbc:db2://localhost:25001/c2c";
		
			
		Connection con;
		Statement stmt;
		String query = "select LASTNAME, FIRSTNAME, EMAIL from CUSTOMERS"; 
	
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

	
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
		}

		try {

			con = DriverManager.getConnection(url,"db2admin","serena");
	
			stmt = con.createStatement();							
	/*
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(1, 'Serena', 'Avanzi', 'sere@sere', '1998-11-13')");
			
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(2, 'Pino', 'Pinco', 'pino@pino', '1963-05-13')");
			
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(3, 'Giallo', 'Bianco', 'giallo@giallo', '1960-02-17')");
			
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(4, 'Viola', 'Lilla', 'viola@viola', '1930-08-23')");
	
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(5, 'Rosa', 'Bianchi', 'rosa@rosa', '2000-03-12')");
			
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(6, 'Viola', 'Blu', 'viola@viola', '1989-09-04')");
			
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(7, 'Arancio', 'Rossi', 'arancio@arancio', '1930-08-23')");
	*/
			stmt.executeUpdate("insert into CUSTOMERS (ID_CUST, FIRSTNAME, LASTNAME, EMAIL, DATE_BIRTH) " +
			         "values(8, 'Arancio', 'Rossi', 'arancio@arancio', '1930-08-23')");
			
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Cognome, nome ed email dei clienti di City2City");
			while (rs.next()) {
				String la = rs.getString("LASTNAME");
				String fi = rs.getString("FIRSTNAME");
				String em=rs.getString("EMAIL");
				System.out.println(la + " " + fi + ", email: "+ em);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

