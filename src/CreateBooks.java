/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 


import java.sql.*;
     
public class CreateBooks {

	public static void main(String args[]) {
		String url = "jdbc:db2://localhost:25001/c2c";
	        
		Connection con;
		String createString;
		createString = "create table BOOKS " + 
						"(ID_BOOKS int NOT NULL, " +
						"DATE_BOOK date, " +
						"DESCRIPTION varchar(20), " +
						"ID_CUST int NOT NULL, " +
						"TRAV_ID int NOT NULL, " +
						"constraint pk_boy_id primary key (ID_BOOKS), " +
						"constraint fk_boy_id foreign key (ID_CUST) references CUSTOMERS (ID_CUST) on delete restrict, " +	
						"foreign key (TRAV_ID) references TRAVELS (TRAV_ID) on delete restrict )";
	
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
	   		stmt.executeUpdate(createString); 
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

