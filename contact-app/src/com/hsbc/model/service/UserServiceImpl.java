package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;
import com.hsbs.model.beans.Contacts;
import com.hsbs.model.beans.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = null;
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance("dao");
	}
	
	@Override
	public User login(int userId, String password) throws  AuthenticationException {
		User user=userDao.authenticate(userId, password);
		if(user==null) {
			throw new AuthenticationException("Invalid Id and Password");
		}
		return user;
		
	}
	@Override
	public User store(User user) {
		return userDao.store(user);
	}

	@Override
	public User edit(int userId, User user) throws UserNotFoundException {
		return userDao.editProfile(userId, user);
	}

	@Override
	public Contacts addContact(int userId, Contacts contact) throws UserNotFoundException, ContactNotFoundException {
		return userDao.addContact(userId, contact);
	}

	@Override
	public List<Contacts> viewAllContatcs(int userId) throws UserNotFoundException {
		return userDao.viewAllContatcts(userId);
	}

	@Override
	public void deleteContact(int contactId, int userId) throws UserNotFoundException, ContactNotFoundException {
		userDao.deleteContacts(contactId, userId);
		
	}

	@Override
	public void deleteProfile(int userId) throws UserNotFoundException {
		userDao.deleteMyProfile(userId);
		
	}


	
	
}
