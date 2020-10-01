package com.hsbc.model.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.utility.UserFactory;

public class UserServiceImpl implements UserService{

	private UserDao userDao = null;
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance("dao");
	}
	
	@Override
	public User login(int userId, String password) throws AuthenticationException {
		User user = userDao.authenticate(userId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went wrong");
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		return userDao.store(user);
	}

	@Override
	public User updatePhone(int userId, long phone) {
		List<User> userList=userDao.fetchAllUsers();
		return null;
		
	}

	@Override
	public User updatePassword(int userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		return userDao.fetchAllUsers();
	}
	
}
