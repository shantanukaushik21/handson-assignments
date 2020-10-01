package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbs.model.beans.Contacts;
import com.hsbs.model.beans.User;

public interface UserService {
	public User login(int userId, String password) throws AuthenticationException;
	public User store(User user);
	public User edit(int userId, User user) throws UserNotFoundException;
	public Contacts addContact(int userId, Contacts contact) throws UserNotFoundException, ContactNotFoundException;
	public List<Contacts> viewAllContatcs(int userId) throws UserNotFoundException;
	//public void deleteContact(int userId, Contacts contact) throws UserNotFoundException, ContactNotFoundException;
	public void deleteProfile(int userId) throws UserNotFoundException;
	public void deleteContact(int contactId, int userId) throws UserNotFoundException, ContactNotFoundException;
	
}
