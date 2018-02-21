package com.ims.dao;

import java.util.List;

import com.ims.actions.Batches;

public interface IBatchesDao {

	List<Batches> readDataFromDb();
	List<Batches> getAllData();
	boolean validateBatch(int org_id,int batch_id);
	Batches addBatch(Batches b);
}
