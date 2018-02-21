package com.ims.actions;

public class UserDetails {
	public int user_details_id;
	public String user_email_id;
	public String user_contact;
	public String user_address;
	
	
	public UserDetails(){
		
	}

	
	public UserDetails(int user_details_id, String user_email_id, String user_contact, String user_address) {
		super();
		this.user_details_id = user_details_id;
		this.user_email_id = user_email_id;
		this.user_contact = user_contact;
		this.user_address = user_address;
		
	}


	public int getUser_details_id() {
		return user_details_id;
	}

	public void setUser_details_id(int user_details_id) {
		this.user_details_id = user_details_id;
	}

	public String getUser_email_id() {
		return user_email_id;
	}

	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	@Override
	public String toString() {
		return "UserDetails [user_details_id=" + user_details_id + ", user_email_id=" + user_email_id
				+ ", user_contact=" + user_contact + ", user_address=" + user_address +  "]";
	}

	
	
}
