package com.demo.jdbc.bl.service;

import java.util.List;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.persistence.entity.Contact;

public interface ContactDao {
	List<ContactDto> findAll();
	void save (Contact contact);
	void delete (int id);
	void update (Contact contact);
	Contact findById(int id);

	}


