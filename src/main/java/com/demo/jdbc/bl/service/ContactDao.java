package com.demo.jdbc.bl.service;



import java.util.List;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.web.form.ContactForm;

public interface ContactDao {
	List<ContactDto> findAll();
	void save (ContactForm contactForm);
	void delete (int id);
	void update (ContactForm contactForm);
	ContactDto findById(int id);

	}


