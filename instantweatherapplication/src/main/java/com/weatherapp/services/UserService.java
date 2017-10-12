package com.weatherapp.services;

import com.weatherapp.model.entities.User;

public interface UserService {
	
	User getUserByNameAndPass(String name, String pass);
	User getUserById(int id);
	int updateUser(User user);
	int createUser(User user);
	int deleteUser(int id);
	
	

}
