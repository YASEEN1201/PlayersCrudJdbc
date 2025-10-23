package com.codegnan.pepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertRecordByPreparedStatement {
	
	static final String jdbc_url="jdbc:mysql://localhost:3306/advanceJava";
	static final String user_name = "root";
	static final String password = "root";
	
	
	public static void main(String[] args) {
		String sqlQuery="Insert into employee(en0,ename,esal,eaddr) values(?,?,?,?)";
		
	  try(Connection connection = DriverManager.getConnection(jdbc_url,user_name,password);
		  PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery)){
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the number of records to insert");
		  int numOfRecords  =sc.nextInt();
		  for(int i=0;i<numOfRecords;i++) {
			  System.out.println("Enter the records details"+(i+1));
		  
		  
		  System.out.println("Enter employee number");
		  int employeeNumber = sc.nextInt();
		  System.out.println("String employee Name");
		  String employeeName = sc.next();
		  System.out.println("Enter employee Salary");
		  double employeeSalary = sc.nextDouble();
		  
		  String employeeAdress = sc.next();
			  preparedStatement.setInt(1,employeeNumber);
			  preparedStatement.setString(2,employeeName);
			  preparedStatement.setDouble(3,employeeSalary);
			  preparedStatement.setString(4,employeeAdress);
			  int rowsAffected = preparedStatement.executeUpdate();
			  
			  if(rowsAffected==1) {
				  System.out.println("Record "+(i+1)+"inserted sucessfully");
			  }else {
				  System.out.println("Record "+(i+1)+" inserted failed");
			  }
		  }
		  
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
		
		
	}
}


