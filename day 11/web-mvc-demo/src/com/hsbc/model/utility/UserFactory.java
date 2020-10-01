package com.hsbc.model.utility;

import com.hsbc.model.dao.JdbcBackedUserDaoImpl;
import com.hsbc.model.model.service.UserServiceImpl;

public class UserFactory {



	public static Object getInstance(String type) {
		if(type.equals("dao")) {
			return new JdbcBackedUserDaoImpl();
		}
		if(type.equals("service")) {
			return new UserServiceImpl();
		}
		return null;
	}
}
