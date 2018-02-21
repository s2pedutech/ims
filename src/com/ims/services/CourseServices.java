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
import javax.ws.rs.core.MediaType;

import com.ims.actions.Courses;
import com.ims.daoimpl.CourseDaoImpl;


@Path("/course")
public class CourseServices {

	CourseDaoImpl cdi = new CourseDaoImpl();
	
	@Path("/allCourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public com.ims.response.Response<Courses> getAllData() {
		List<Courses> cList = this.cdi.getAllData();

		Map<String, List<?>> m = new HashMap<>();
		m.put("courses", cList);
		List<String> msgs = new ArrayList<>();
		com.ims.response.Response<Courses> r = new com.ims.response.Response<Courses>("OK", 200, msgs, m);
		System.out.println(r);
		return r;
	}	
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newCourse")
	public com.ims.response.Response<Courses> addCourse(Courses cr){
		
		com.ims.response.Response<Courses> resp ;
		List<Courses> courseList = this.cdi.getAllData();
		Map<String, List<?>> map = new HashMap<>();	
		List<String> msgs = new ArrayList<>();
		if(cdi.validateCourse(cr.getCourse_id())){
			
			msgs.add("Course ID already exists");
			map.put("Courses", courseList);
			resp= new com.ims.response.Response<Courses>("Not Accpetable",406,msgs,map);
			System.out.println(resp);
			return resp;
		}
		else{
			cdi.addCourse(cr);
			msgs.add("New course added");
			courseList.add(cr);
			map.put("Courses", courseList);
			resp=new com.ims.response.Response<Courses>("OK",200,msgs,map);
			return resp;
		}
	
    	
		

		
	}
}
