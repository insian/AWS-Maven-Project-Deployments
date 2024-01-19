package com.ibm.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyFactory {
	private static Connection connection = null;
	public static Connection getMyConnection() throws SQLException {
		if(connection==null) {
			new MyFactory();
		}
		return connection;
	}
	private MyFactory() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://44.222.153.88:3307/hr","root","root");
	}
}
