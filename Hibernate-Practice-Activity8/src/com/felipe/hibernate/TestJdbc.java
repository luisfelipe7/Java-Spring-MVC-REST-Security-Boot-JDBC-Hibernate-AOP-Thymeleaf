/**
 * 
 */
package com.felipe.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Felipe Castro
 *
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* Testing the connectivity with the database */
		/* Defining the URL, User and Password to Access */
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			/* Connecting to the database */
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!!!");
			
		}
		catch(Exception exc) {
			System.out.println("Connection Failed , "+exc.getMessage());
			exc.printStackTrace();
		}


	}

}
