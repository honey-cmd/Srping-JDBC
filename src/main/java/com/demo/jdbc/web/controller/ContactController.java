package com.demo.jdbc.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.bl.service.ContactService;
import com.demo.jdbc.web.form.ContactForm;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactDao;

	@GetMapping("/list")
	public ModelAndView getallContact() {
		ModelAndView mv = new ModelAndView("postListView");
		List<ContactDto> contactDtoList = this.contactDao.findAll();
		mv.addObject("contacts", contactDtoList);
		return mv;

	}

	@GetMapping("/delete")
	public ModelAndView deleteContact(@RequestParam int deleteId) {
		ModelAndView mv = new ModelAndView();
		contactDao.delete(deleteId);
		mv.setViewName("redirect:/list");
		return mv;
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("postListView");
		mv.addObject("saveForm", new ContactForm());
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute("saveForm") @Valid ContactForm contactForm, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("/create");
			return mv;
		}

		contactDao.save(contactForm);
		mv.setViewName("redirect:/list");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int updateObjId) {
		ModelAndView mv = new ModelAndView();
		ContactDto contactDto = contactDao.findById(updateObjId);

		mv.addObject("updateForm", new ContactForm(contactDto));
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editContact(@ModelAttribute("updateForm") @Valid ContactForm contactForm,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("/update");
			return mv;
		}
		contactDao.update(contactForm);
		mv.setViewName("redirect:/list");
		return mv;
	}

}
