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

import com.ims.actions.Organization;
import com.ims.daoimpl.OrganizationDaoImpl;

@Path("/org")
public class OrganizationServices {

	OrganizationDaoImpl odi = new OrganizationDaoImpl();
	
	@Path("/allOrg")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Organization> getAllData() {
		List<Organization> orgList = this.odi.getAllData();

		return orgList;
	}	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newOrg")
	public com.ims.response.Response<Organization> addOrganization(Organization or){
		com.ims.response.Response<Organization> resp ;
		List<Organization> orgList = this.odi.getAllData();
		Map<String, List<?>> map = new HashMap<>();	
		List<String> msgs = new ArrayList<>();
		if(odi.validateOrganization(or.getOrg_id(), or.getOrg_name())){
			
			msgs.add("Organization already exists");
			map.put("Organization", orgList);
			resp= new com.ims.response.Response<Organization>("Not Accpetable",406,msgs,map);
			System.out.println(resp);
			return resp;
		}
		else{
			odi.addOrganization(or);
			msgs.add("New orrganization added");
			orgList.add(or);
			map.put("Organization", orgList);
			resp=new com.ims.response.Response<Organization>("OK",200,msgs,map);
			return resp;
		}

		
	}
}
