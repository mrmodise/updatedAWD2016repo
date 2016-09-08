package com.bac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.bac.model.Student;

public class DatabaseDAO {
	
	static PreparedStatement ps;
	static Statement stmt;
	static ResultSet rs;
	static Connection connection;

	public DatabaseDAO() {
		CreateStatements.createStudentTable();
		
	}

	public Student saveStudent(Student student) {
		String sqlInsert = "insert into Student values (?, ?)";
		try {
			// create connection to database
			connection = DatabaseConnection.getConnection();
			
			// an insert
			ps = connection.prepareStatement(sqlInsert);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getFirstName());
			
			//execute the statement
			ps.executeUpdate();
			
			//user feedback
			JOptionPane.showMessageDialog(null, "Student Successfully Captured");
		} catch (SQLException es) {
			es.printStackTrace();
		}
		
		return student;
	}

	
}
