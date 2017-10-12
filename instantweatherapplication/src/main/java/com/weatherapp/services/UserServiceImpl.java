package com.weatherapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapp.model.dao.UserDaoInterface;
import com.weatherapp.model.entities.User;




@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoInterface userDao;

	public User getUserByNameAndPass(String name, String pass) {
		return userDao.getUserByNameAndPass(name, pass);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int createUser(User user) {
		return userDao.createUser(user);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	
	
}
