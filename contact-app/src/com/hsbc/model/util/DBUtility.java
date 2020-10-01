package com.hsbc.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;


public class DBUtility {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName(ClientDriver.class.getName());
		Connection connection = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/contactapp", "shantanu", "shantanu123");
		return connection;
	}
}
