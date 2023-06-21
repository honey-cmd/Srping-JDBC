package com.demo.jdbc.bl.dto;


import com.demo.jdbc.persistence.entity.Contact;

import lombok.AllArgsConstructor;


import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor

public class ContactDto {

	
private int id;
private String name;
private String email;
private String address;
private String phone;


	public ContactDto (Contact contact) {
		this.id=contact.getId();
		this.name=contact.getName();
		this.email=contact.getEmail();
		this.address=contact.getAddress();
		this.phone=contact.getPhone();
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public String getPhone() {
		return phone;
	}






	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

	
	
	

}
