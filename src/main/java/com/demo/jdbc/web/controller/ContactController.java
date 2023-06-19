package com.demo.jdbc.web.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.bl.service.ContactDao;




@Controller
public class ContactController {
	
	@Autowired
private ContactDao contactDao;
	
	@GetMapping("/list")
	public ModelAndView getallContact() {
		ModelAndView mv = new ModelAndView();
		List<ContactDto> contactDtoList = this.contactDao.findAll();
		System.out.println(contactDtoList );
		mv.addObject("contacts",contactDtoList);
	return mv;
		
	}
	

	


}
