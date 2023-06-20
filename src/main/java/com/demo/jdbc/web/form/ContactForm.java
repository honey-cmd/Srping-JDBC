package com.demo.jdbc.web.form;

import org.hibernate.validator.constraints.NotBlank;

import com.demo.jdbc.bl.dto.ContactDto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;




public class ContactForm {
	
	private int id;
@NotBlank(message = "Please enter name")
	private String name;
@NotBlank(message = "Please enter email")
	private String email;
@NotBlank(message = "Please enter address")
	private String address;
@NotBlank(message = "Please enter phone")
	private String phone;
	



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
	public ContactForm(ContactDto contactDto) {
		this.id=contactDto.getId();
		this.name=contactDto.getName();
		this.email=contactDto.getAddress();
		this.phone=contactDto.getPhone();
	}

	public ContactForm(int id, String name, String email, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public ContactForm() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	

}
