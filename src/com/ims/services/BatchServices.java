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

import com.ims.actions.Batches;
import com.ims.daoimpl.BatchDaoImpl;

@Path("/batch")
public class BatchServices {

	BatchDaoImpl bdi =  new BatchDaoImpl();
	
	 
	@Path("/allBatches")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Batches> getAllData() {
		List<Batches> bList = this.bdi.getAllData();

		return bList;
	}	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newBatch")
	public com.ims.response.Response<Batches> addBatch(Batches b){
		
		com.ims.response.Response<Batches> resp ;
		List<Batches> batchList = this.bdi.getAllData();
		Map<String, List<?>> map = new HashMap<>();	
		List<String> msgs = new ArrayList<>();
		if(bdi.validateBatch(b.getOrg_id(), b.getBatch_id())){
			
			msgs.add("Batch already exists");
			map.put("Batches", batchList);
			resp= new com.ims.response.Response<Batches>("Not Accpetable",406,msgs,map);
			System.out.println(resp);
			return resp;
		}
		else{
			bdi.addBatch(b);
			msgs.add("New batch added");
			batchList.add(b);
			map.put("Batches", batchList);
			resp=new com.ims.response.Response<Batches>("OK",200,msgs,map);
			return resp;
		}
	
    	
	}
	

}
