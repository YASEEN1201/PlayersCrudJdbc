package com.codegnan.pepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateRecordByPreparedStatement {

	static final String jdbc_url="jdbc:mysql://localhost:3306/advanceJava";
	static final String user_name = "root";
	static final String password = "root";
	
	public static void main(String[] args) {
//		String query = "delete employee where en0=?"
//		
		String updateQuery = "UPDATE employee SET ename=?, esal=?, eaddr=? WHERE en0=?";
		 try (Connection connection = DriverManager.getConnection(jdbc_url, user_name, password);
				PreparedStatement pst = connection.prepareStatement(updateQuery)){
			 
			pst.setString(1, "kumar");
			pst.setInt(2, 90000);
			pst.setString(3, "canada");
			pst.setInt(4, 777);
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected==1) {
				System.out.println("record inserted sucessfully");
			}else {
				System.out.println("");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	

	}

}
