/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertBooks {

	public static void main(String args[]) {
		  
		
		String url = "jdbc:db2://localhost:25001/c2c";
		
			
		Connection con;
		Statement stmt;
		String query = "select ID_BOOKS, ID_CUST, DATE_BOOK from BOOKS"; 
	
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
			stmt.executeUpdate("insert into BOOKS (ID_BOOKS, DATE_BOOK, DESCRIPTION, ID_CUST, TRAV_ID) " +
			         "values(1, '2020-05-18', 'prenotazione 1', 1, 5)");
			         
			stmt.executeUpdate("insert into BOOKS (ID_BOOKS, DATE_BOOK, DESCRIPTION, ID_CUST, TRAV_ID) " +
			         "values(2, '2020-07-29', 'prenotazione 2', 4, 1)");
			
			stmt.executeUpdate("insert into BOOKS (ID_BOOKS, DATE_BOOK, DESCRIPTION, ID_CUST, TRAV_ID) " +
			         "values(3, '2021-06-19', 'prenotazione 3', 6, 2)");
			
			stmt.executeUpdate("insert into BOOKS (ID_BOOKS, DATE_BOOK, DESCRIPTION, ID_CUST, TRAV_ID) " +
			         "values(4, '2021-10-24', 'prenotazione 4', 2, 3)");
			*/
			
			stmt.executeUpdate("insert into BOOKS (ID_BOOKS, DATE_BOOK, DESCRIPTION, ID_CUST, TRAV_ID) " +
			         "values(10, '2021-10-24', 'prenotazione 5', 4, 5)");
			
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Codice della prenotazione, data e id cliente");
			while (rs.next()) {
				int ib = rs.getInt("ID_BOOKS");
				Date db = rs.getDate("DATE_BOOK");
				int ic=rs.getInt("ID_CUST");
				System.out.println(ib + ", " + db + ", riferita a cliente con codice: "+ ic);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

