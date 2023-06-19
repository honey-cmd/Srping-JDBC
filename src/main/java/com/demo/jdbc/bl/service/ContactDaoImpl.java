package com.demo.jdbc.bl.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.persistence.entity.Contact;
import com.demo.jdbc.web.form.ContactForm;

@Service
@Transactional
public class ContactDaoImpl implements ContactDao {

	static class UserMapper implements RowMapper<Contact> {
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setAddress(rs.getString("address"));
			contact.setPhone(rs.getString("phone"));

			return contact;

		}

	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(ContactForm contactForm) {
		String sql = "INSERT INTO contact (id,name,email,address,phone) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, contactForm.getId(),contactForm.getName(), contactForm.getEmail(), contactForm.getAddress(),
				contactForm.getPhone());

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM contact WHERE id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public void update(ContactForm contactForm) {
		String sql = "UPDATE contact SET name = ? , email=? , address=? ,phone=? WHERE id=? ";
		jdbcTemplate.update(sql, contactForm.getName(), contactForm.getEmail(), contactForm.getAddress(),
				contactForm.getPhone(), contactForm.getId());

	}



	@Override
	public List<ContactDto> findAll() {
		String sql = "select * from contact";
		var contactObj = jdbcTemplate.query(sql, new UserMapper());
		return contactObj.stream().map(obj -> new ContactDto(obj)).toList();

	}

	@Override
	public ContactDto findById(int id) {
		String sql = "SELECT * FROM contact WHERE id=?";
		@SuppressWarnings("deprecation")
		Contact contactData = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {
			Contact contact = new Contact();
			contact.setId(rs.getInt(id));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setAddress(rs.getString("address"));
			contact.setPhone(rs.getString("phone"));
			return contact;

		});

		return new ContactDto(contactData);

	}

	
	


}
