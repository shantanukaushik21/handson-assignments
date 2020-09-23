package com.hsbc.model.dao;

import java.util.ArrayList;

import com.hsbc.model.beans.User;

public class CollectionBackedUserDao implements UserDao {
	
	// create a ArrayList with List reference
	ArrayList<User> userList=new ArrayList<>();
	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
		//User[] userArray=(User[]) userList.toArray();
		return user;
	}

	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
		User[] userArray=userList.toArray(new User[userList.size()]);
		return userArray;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		for(User user : userList) {
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		for(User user1 : userList) {
			if(user1.getUserId()==userId) {
				userList.remove(user1);
				userList.add(user);
				return user;
			}
		}
		
		return null;
	}

}
