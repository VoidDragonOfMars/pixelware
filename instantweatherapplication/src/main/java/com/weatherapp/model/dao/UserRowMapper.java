package com.weatherapp.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.weatherapp.model.entities.User;



public class UserRowMapper implements RowMapper<User> {

	
	public User mapRow(ResultSet resulset, int rowNumber) throws SQLException {
		User user = new User(resulset.getInt("ID"), resulset.getString("NAME"), 
				resulset.getString("EMAIL"), resulset.getDate("DATE"),resulset.getString("COUNTRY"), resulset.getString("PASS"));

		return user;
	}

	

}
