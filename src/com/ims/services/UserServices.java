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

import com.ims.actions.Users;
import com.ims.daoimpl.UserDaoImpl;

@Path("/UserLogin")               
public class UserServices extends Application {

	UserDaoImpl udi = new UserDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validateUser")
	public com.ims.response.Response<Users> validateUserLogin(Users u)
	{
		
		System.out.println(u);
		
		if(udi.validateUser(u.getUsername(), u.getUser_password()))
		{
			Map<String, List<?>> m = new HashMap<>();
			
			List<String> msgs = new ArrayList<>();
			msgs.add("Successful Login");
			com.ims.response.Response<Users> r = new com.ims.response.Response<Users>("OK", 200, msgs, m);
			System.out.println(r);
			return r;
		}
		else{
			Map<String, List<?>> map = new HashMap<>();
			
			List<String> msgs = new ArrayList<>();
			msgs.add("Invalid Login");
			com.ims.response.Response<Users> r1 = new com.ims.response.Response<Users>("not ok", 406, msgs, map);
			System.out.println(r1);
			return r1;
		}
		
		
	}
	
	@Path("/allUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Users> getAllUser() {
		List<Users> usersList = this.udi.getAllUsers();

		return usersList;
		
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newUser")
	public com.ims.response.Response<Users> addUser(Users u){
		com.ims.response.Response<Users> resp ;
		List<Users> usersList = this.udi.getAllUsers();
		Map<String, List<?>> map = new HashMap<>();	
		List<String> msgs = new ArrayList<>();
		if(udi.validateUser(u.getUsername(), u.getUser_password())){
			
			msgs.add("User already exists");
			map.put("users", usersList);
			resp= new com.ims.response.Response<Users>("Not Accpetable",406,msgs,map);
			System.out.println(resp);
			return resp;
		}
		else{
			udi.addUser(u);
			msgs.add("New user added");
			usersList.add(u);
			map.put("Users", usersList);
			resp=new com.ims.response.Response<Users>("OK",200,msgs,map);
			return resp;
		}
		
	}
		
}