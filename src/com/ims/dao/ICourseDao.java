package com.ims.dao;

import java.util.List;

import com.ims.actions.Courses;

public interface ICourseDao {
	List<Courses> readCoursesFromDb();
	boolean validateCourse(int course_id);
	List<Courses> getAllData();
	Courses addCourse(Courses c);
}
