package com.ims.dao;

import java.util.List;

import com.ims.actions.Organization;


public interface IOrganizationDao {

	List<Organization> readDataFromDb();
	List<Organization> getAllData();
	boolean validateOrganization(int org_id,String org_name);
	Organization addOrganization(Organization org);
}
