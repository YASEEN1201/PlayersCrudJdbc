package com.codegnan.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	static final String jdbc_url="jdbc:mysql://localhost:3306/advanceJava";
	static final String user_name = "root";
	static final String password = "root";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbc_url,user_name,password);
	}
}
