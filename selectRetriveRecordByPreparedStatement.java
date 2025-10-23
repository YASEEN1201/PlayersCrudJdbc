package com.codegnan.pepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectRetriveRecordByPreparedStatement {
	static final String jdbc_url="jdbc:mysql://localhost:3306/advanceJava";
	static final String user_name = "root";
	static final String password = "root";
	public static void main(String[] args) {
		
		String sqlQuery = "select*from employee where en0=?";
		
		 try(Connection connection = DriverManager.getConnection(jdbc_url,user_name,password);
				  PreparedStatement pst=connection.prepareStatement(sqlQuery)){
		        
			 pst.setInt(1, 777);
			 
			 ResultSet rs = pst.executeQuery();
			 
			 if(rs.next()) {
				 System.out.println("Emplyee Details");
				 System.out.println("Employee Number:"+rs.getInt(1));
				 System.out.println("Employee Name:"+rs.getString(2));
				 System.out.println("Employee Salary:"+rs.getDouble(3));
				 System.out.println("Employee Address:"+rs.getString(4));
			 }else {
				 System.out.println("No record found for employee Number");
			 }

	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

}
