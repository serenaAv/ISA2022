package isa.ProgettoEsame.ClassiProgettoIniziale;
/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertBus {

	public static void main(String args[]) {
		  
		String url = "jdbc:db2://localhost:25001/c2c";
		Connection con;
		Statement stmt;
		String query = "select ID_BUS, PLATE, DATE_LAST_REV, DATE_LAST_CARSERV from BUS";
		//voglio visualizzare ID del bus, targa e data ultima revisione
	
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
			stmt.executeUpdate("insert into BUS " +
	                 "values(1, 'AA123QW', 2010, 'senza climatizzatore', '2021-01-27', '2021-06-15')");
		
			stmt.executeUpdate("insert into BUS " +
	                 "values(2, 'BB567LK', 2015, 'ottimo stato', '2021-05-27', '2022-08-15')");
			
			stmt.executeUpdate("insert into BUS " +
	                 "values(3, 'MM451HU', 2018, 'nuovo', '2022-01-03', '2021-12-15')");
			*/
			stmt.executeUpdate("insert into BUS " +
	                 "values(4, 'PI551HU', 2018, 'senza radio', '2022-02-25', '2021-10-19')");
			
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Bus di propriet� di City2City: targa, ultima revisione ed ultimo tagliando");
			while (rs.next()) {
				String p = rs.getString("PLATE");
				Date lr = rs.getDate("DATE_LAST_REV");
				Date lcs = rs.getDate("DATE_LAST_CARSERV");
				System.out.println(p + ": ultima revisione: " + lr + " ultimo tagliando: " + lcs);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

