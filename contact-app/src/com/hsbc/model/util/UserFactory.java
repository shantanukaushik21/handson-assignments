package com.hsbc.model.util;

import com.hsbc.model.dao.UserDaoImpl;
import com.hsbc.model.service.UserServiceImpl;

public class UserFactory {
	public static Object getInstance(String type) {
		if(type.equals("dao")) {
			return new UserDaoImpl();
		}
		if(type.equals("service")) {
			return new UserServiceImpl();
		}
		return null;
	}
}
