package com.bac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatements {
	
	static PreparedStatement ps;
	static Statement stmt;
	static ResultSet rs;
	static Connection connection;
	
	public static void createStudentTable() {
		// SQL statement to create table
		String sqlCreateStudent = "create table student(" 
				+ "id INTEGER not NULL," 
				+ "firstName VARCHAR(255),"
				+ "PRIMARY KEY ( id )" 
				+ ")";

		try {
			// create connection to the database
			connection = DatabaseConnection.getConnection();

			// execute SQL statement above
			stmt = connection.createStatement();

			// execute statement
			stmt.executeUpdate(sqlCreateStudent);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					connection.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}
}
