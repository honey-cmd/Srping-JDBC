package com.demo.jdbc.bl.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.demo.jdbc.bl.dto.ContactDto;
import com.demo.jdbc.persistence.entity.Contact;



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
	public void save(Contact contact) {
		String sql = "INSERT INTO contact (name,email,address,phone) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,contact.getName(),contact.getEmail(),contact.getAddress(),contact.getPhone());
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql,id);
		
	}

	@Override
	public void update(Contact contact) {
	String sql = "UPDATE contact SET name = ? , email=? , address=? ,phone=? WHERE contact_id=? ";
	jdbcTemplate.update(sql,contact.getName(),contact.getEmail(),contact.getAddress(),contact.getPhone(),contact.getId());
		
	}

	@Override
	public Contact findById(int id) {
	
		return null; 
		
		
	}

	@Override
	public List<ContactDto> findAll() {
		String sql = "select * from contact";
		var contactObj = jdbcTemplate.query(sql, new UserMapper());
		return contactObj.stream().map(obj -> new ContactDto(obj)).toList();
		
	 
	
	}





}
