package com.weatherapp.model.dao;

import com.weatherapp.model.entities.User;

public interface UserDaoInterface {
	
	
	User getUserByNameAndPass(String name, String pass);
	User getUserById(int id);
	int createUser(User user);
	int deleteUser(int id);
	int updateUser(User user);

}
