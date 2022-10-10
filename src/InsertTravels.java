/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertTravels {

	public static void main(String args[]) {
		  
		
		String url = "jdbc:db2://localhost:25001/c2c";
		
			
		Connection con;
		Statement stmt;
		String query = "select TRAV_ID, TIME_ARR_REAL, N_PASS from TRAVELS"; 
		//visualizzo ID del viaggio, l'ora di arrivo e il numero di passeggeri
	
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
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS) " +
			         "values(1, '2020-05-18', '9.45.00', '13.30.00', 20, 1, 2)");
			
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(2, '2020-07-24', '9.05.00', '13.00.00', 30, 4, 1)");
			
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(3, '2021-02-18', '10.00.00', '18.30.00', 50, 5, 3)");
	
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(4, '2022-04-25', '06.30.00', '22.30.00', 27, 2, 2)");
	*/
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(5, '2019-12-31', '14.30.00', '20.15.00', 15, 1, 1)");
		/*	
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(6, '2021-06-28', '05.35.00', '15.45.00', 40, 3, 3)");
			
			stmt.executeUpdate("insert into TRAVELS (TRAV_ID, DATE, TIME_DEP_REAL, TIME_ARR_REAL, N_PASS, LINK_ID, ID_BUS)" +
			         "values(7, '2022-02-15', '12.30.00', '16.00.00', 35, 4, 2)");
	*/
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Codice del viaggio, ora d'arrivo e numero passeggeri");
			while (rs.next()) {
				int it = rs.getInt("TRAV_ID");
				Time ta = rs.getTime("TIME_ARR_REAL");
				int n=rs.getInt("N_PASS");
				System.out.println(it + ": ora d'arrivo " + ta + ", numero passeggeri: "+ n);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

