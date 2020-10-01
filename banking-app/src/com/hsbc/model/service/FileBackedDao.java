package com.hsbc.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileBackedDao implements UserDao{
	
	ArrayList<User> userList=new ArrayList<User>();
	
	
		try {
			//ArrayList<User> userList=new ArrayList<User>();
			FileOutputStream fos = new FileOutputStream("fileDb.ser");
			// creates an instance that can store complex object into the output stream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList); // checks whether the object is Serializable type
			System.out.println("Object Serialized");
			fos.flush(); // flushes the output stream
			oos.close();
			fos.close();
		}
	
	@Override
	public User store(User user) {
		
		FileInputStream fis = new FileInputStream("fileDb.ser");
		// allows you to read the object from the input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<User> userList = (ArrayList<User>)ois.readObject();
		
		// TODO Auto-generated method stub
		userList.add(user);
		
		FileOutputStream fos = new FileOutputStream("fileDb.ser");
		// creates an instance that can store complex object into the output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(userList);
		
		ois.close();
		fis.close();
		
		
		return user;
	}
	
	private void serialize(List<User> userList) {
		try {
			FileOutputStream fos = new FileOutputStream("fileDb.ser");
			// creates an instance that can store complex object into the output stream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
		}
	}
	private List<User> deserialize(){
		
	}
	
	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("fileDb.ser");
		// allows you to read the object from the input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<User> list = (List<User>)ois.readObject();
		
		User[] userArray=list.toArray(new User[userList.size()]);
		
		ois.close();
		fis.close();
		
		return userArray;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("fileDb.ser");
		// allows you to read the object from the input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<User> list = (List<User>)ois.readObject();
		
		for(User user : list) {
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("fileDb.ser");
		// allows you to read the object from the input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<User> list = (List<User>)ois.readObject();
		
		for(User user1 : list) {
			if(user1.getUserId()==userId) {
				userList.remove(user1);
				userList.add(user);
				
				FileOutputStream fos = new FileOutputStream("fileDb.ser");
				// creates an instance that can store complex object into the output stream
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userList); // checks whether the object is Serializable type
				
				return user;
			}
		}
		
		return null;
	}

}
