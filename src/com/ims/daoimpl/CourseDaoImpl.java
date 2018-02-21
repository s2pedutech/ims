package com.ims.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ims.actions.Courses;
import com.ims.dao.ICourseDao;
import com.ims.util.DBConnectionManager;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public List<Courses> readCoursesFromDb() {
		List<Courses> courseList = new ArrayList<Courses>();
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query1 = "select * from courses";
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String duration = resultSet.getString(3);
				Double fees = resultSet.getDouble(4);
				Courses course = new Courses(id, name, duration, fees);
				courseList.add(course);
			}
			
		}	catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
		System.out.println(courseList);
		
		return courseList;
		
	}
	public boolean validateCourse(int course_id){
DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from courses where course_id='" + course_id + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			int checkId=resultSet.getInt(1);
		    
		    if(checkId==(course_id))
		    	return true;
		    return false;
		}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
		
	

	@Override
	public List<Courses> getAllData() {
		
		return readCoursesFromDb();
	}

	@Override
	public Courses addCourse(Courses c) {
		DBConnectionManager dbm = new DBConnectionManager();
		try {
			Connection connection = dbm.getConnection();
			String query = "insert into courses(course_id,course_name,course_duration,course_fees) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, c.getCourse_id());
			preparedStatement.setString(2, c.getCourse_name());
			preparedStatement.setString(3,c.getCourse_duration());
			preparedStatement.setDouble(4, c.getCourse_fees());
			preparedStatement.executeUpdate();
			String query1 = "insert into course_details(course_details_id,course_contents,course_description,course_id) values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.setInt(1, c.getCourse_details().getCourse_details_id());
			ps.setString(2,c.getCourse_details().getCourse_contents());
			ps.setString(3, c.getCourse_details().getCourse_description());
			ps.setInt(4, c.getCourse_id());
			ps.executeUpdate();
			preparedStatement.close();
			ps.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(c);
		return c;
	}
	
}
