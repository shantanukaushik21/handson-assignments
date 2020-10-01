package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbs.model.beans.Contacts;
import com.hsbs.model.beans.User;

public interface UserDao {
	
	public User authenticate(int userid, String pass)throws AuthenticationException;
	public User store(User user);
	public User getUserById(int userid)throws UserNotFoundException;
	public User editProfile(int id, User user) throws UserNotFoundException;
	public Contacts addContact(int userId, Contacts contact)throws UserNotFoundException, ContactNotFoundException;
	public List<Contacts> viewAllContatcts(int userId) throws UserNotFoundException;
	public void deleteContacts(int contactId, int UserId) throws UserNotFoundException, ContactNotFoundException;
	public void deleteMyProfile(int userId)throws UserNotFoundException;
	
}
