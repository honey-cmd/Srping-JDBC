package com.demo.jdbc.bl.dto;





import com.demo.jdbc.persistence.entity.Contact;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
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
	
	

	
	
	

}
