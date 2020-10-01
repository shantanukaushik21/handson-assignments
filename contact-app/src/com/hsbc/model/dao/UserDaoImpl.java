package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.util.DBUtility;
import com.hsbs.model.beans.Contacts;
import com.hsbs.model.beans.User;

public class UserDaoImpl implements UserDao{

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
				user.setUserId(userId);
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getInt("phone"));
				user.setDob(resultSet.getString("dob"));
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
		
		try {
			Connection connection = (Connection) DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			PreparedStatement ps = connection.prepareStatement("insert into user_table values(?,?,?,?,?)");
			ps.setInt(1, seq);
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getPhone());
			ps.setString(5, user.getDob());
			
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
	public User editProfile(int id, User user) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement updateStatement = connection.prepareStatement("update user_table set name=?, password=?, phone=?,dob=? where user_id=?");
			updateStatement.setString(1, user.getName());
			updateStatement.setString(2, user.getPassword());
			updateStatement.setInt(3, user.getPhone());
			updateStatement.setString(4, user.getDob());
			updateStatement.setInt(5, user.getUserId());
							
			updateStatement.executeUpdate();

			updateStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Contacts addContact(int userId, Contacts contact) {
		try {
		Connection connection = DBUtility.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into contact table values(next value for con_seq,?,?,?)");
		ps.setString(1, contact.getName());
		ps.setInt(2, contact.getPhoneNumber());
		ps.setInt(3, userId);
		ps.execute();
		ps.close();
		connection.close();
		
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public List<Contacts> viewAllContatcts(int userId) {
		
		List<Contacts> contactList=null;;
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("Select * from contact_table where user_id=?");
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Contacts contact=null;
				contact.setContactId(rs.getInt("contact_id"));
				contact.setName(rs.getString("cname"));
				contact.setPhoneNumber(rs.getInt("phone"));
				contactList.add(contact);
			}
			rs.close();
			ps.close();
			connection.close();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return contactList;
	}

	@Override
	public void deleteContacts(int contactId, int userId) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from contact_table where user_id=? && contact_id=?");
			ps.setInt(1, userId);
			ps.setInt(2, contactId);
			ps.execute();
			ps.close();
			connection.close();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMyProfile(int userId) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from contact_table where user_id=?");
			ps.setInt(1, userId);
			ps.execute();
			ps.close();
			
			PreparedStatement pss=connection.prepareStatement("delete from user_table where user_id=?");
			pss.setInt(1, userId);
			pss.execute();
			pss.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		
	}
	@Override
	public User getUserById(int userid) throws UserNotFoundException {
		User user=null;
		try {	
		Connection connection = DBUtility.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from user_table where user_Id=?");
		ResultSet rs=ps.executeQuery();
		int check =0;
		if(rs.next()) {
			check++;
			
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getInt("phone"));
			user.setDob(rs.getString("dob"));
			return user;
		}
		if(check==0) {
			throw new UserNotFoundException("user with id "+ userid+" does not exists");
		}
		
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	
}
