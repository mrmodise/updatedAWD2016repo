package com.bac.service.impl;

import com.bac.dao.DatabaseDAO;
import com.bac.model.Student;
import com.bac.service.StudentService;

/**
 * 
 * @author mrmodise
 *	this is what you are going to call in your servlets, like this, StudentService student = new StudentServiceImpl()
 */
public class StudentServiceImpl implements StudentService {

	DatabaseDAO dao = new DatabaseDAO();

	public Student saveStudent(Student student) {
		return dao.saveStudent(student);
	}
}
