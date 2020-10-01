package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.utility.DBUtility;

public class JdbcBackedUserDaoImpl implements UserDao{

	
	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection =  DBUtility.getConnection();
			String loginQuery = "select * from user_table where user_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(user == null) {
				throw new AuthenticationException("Sorry Username or Password is Incorrect");
			} 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	@Override
	public User store(User user) {
		User newuser=user;
		try {
			Connection connection = (Connection) DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			PreparedStatement ps = connection.prepareStatement("insert into user_table values(?,?,?,?)");
			ps.setInt(1, seq);
			ps.setString(2, newuser.getName());
			ps.setString(3, user.getPassword());
			ps.setLong(4, user.getPhone());
			
			ps.executeUpdate();
			ps.close();
			connection.close();
			return user;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public List<User> fetchAllUsers() {
		
		List<User> userList=new ArrayList<>();
		try {
			Connection connection = (Connection) DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user_table");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id")); 
				user.setName(rs.getString("name")); 
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				userList.add(user);
			}
			rs.close();
			ps.close();
			connection.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User updateUser(int userId, User user) throws UserNotFoundException {
		
		try {
		Connection connection = (Connection) DBUtility.getConnection();
		PreparedStatement ps = connection.prepareStatement("Delete from user_table where user_id=?");
		ps.setInt(1, userId);
		int check=ps.executeUpdate();
		store(user);
		
		if(check==0) {
			throw new UserNotFoundException("the user Id = "+userId+"does not exist");
		}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		User user=null;
		try {
			Connection connection = (Connection) DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user_table where user_id=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			int check=0;
			if(rs.next()) {
				check++;
				user.setUserId(rs.getInt("user_id")); 
				user.setName(rs.getString("name")); 
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				
			}
			if(check==0) {
				throw new UserNotFoundException("the user Id = "+userId+"does not exist");
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
		
		
	
}
