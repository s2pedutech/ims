package com.ims.dao;

import java.util.List;
import com.ims.actions.Student;


public interface IStudentDao {

	List<Student> readStudentFromDb();
	List<Student> getAllStudents();
	boolean validateStudent(int student_id);
	Student addStudent(Student student);
}
