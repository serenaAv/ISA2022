/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class CreateTravels {

	public static void main(String args[]) {

		String url = "jdbc:db2://localhost:25001/c2c";
		
		Connection con;
		String createString;
		createString = "create table TRAVELS" +
							"(TRAV_ID int NOT NULL, " +
							"DATE date, " +
							"TIME_DEP_REAL time, " +
							"TIME_ARR_REAL time, " +
							"N_PASS int, " +
							"ID_BUS int," +
							"LINK_ID int, " +
							"constraint pk_boy_id primary key (TRAV_ID)," +
							"constraint fk_boy_id foreign key (ID_BUS) references BUS (ID_BUS) on delete restrict, " +
							"foreign key (LINK_ID) references LINKS (LINK_ID) on delete restrict )";
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

