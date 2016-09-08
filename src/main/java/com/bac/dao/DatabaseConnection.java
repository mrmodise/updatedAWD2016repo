package com.bac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author mrmodise
 * @purpose to connect the application to the database
 */
public class DatabaseConnection {
	
	// database and JDBC properties
	static Connection connection;
	static String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	static String dbClass = "org.h2.Driver";
	static String username = "sa";
	static String password = "";

	// method to create connection to the database
	public static Connection getConnection() {
		try {
			// retrieve H2 driver
			Class.forName(dbClass);
			
			// the actual connection takes place
			connection = DriverManager.getConnection(dbUrl, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// to make use of it in other classes
		return connection;
	}
}
