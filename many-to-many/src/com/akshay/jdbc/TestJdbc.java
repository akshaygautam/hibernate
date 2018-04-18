package com.akshay.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			System.out.println("Connecting to db: "+jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection successful");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
