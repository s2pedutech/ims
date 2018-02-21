package com.ims.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.ims.actions.Student;
import com.ims.daoimpl.StudentDaoImpl;


@Path("/student")
public class StudentServices extends Application {

	StudentDaoImpl sdi = new StudentDaoImpl();
	
	@Path("/allStudents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		List<Student> studentList = this.sdi.getAllStudents();

		return studentList;
	}	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newStudent")
	public com.ims.response.Response<Student> addStudents(Student s){
		
		com.ims.response.Response<Student> resp ;
		List<Student> studentList = this.sdi.getAllStudents();
		Map<String, List<?>> map = new HashMap<>();	
		List<String> msgs = new ArrayList<>();
		if(sdi.validateStudent(s.getStudent_id())){
			
			msgs.add("Student ID already exists");
			map.put("Student", studentList);
			resp= new com.ims.response.Response<Student>("Not Accpetable",406,msgs,map);
			System.out.println(resp);
			return resp;
		}
		else{
			sdi.addStudent(s);
			msgs.add("New course added");
			studentList.add(s);
			map.put("Students", studentList);
			resp=new com.ims.response.Response<Student>("OK",200,msgs,map);
			return resp;
		}
		

		
	}
}
