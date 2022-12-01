package com.data.onetomany;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/one2many?useSSL=false&allowPublicKeyRetrieval=true";
		String user ="cab";
		String pass ="cab";
		try {
			System.out.println("Connecting to database" +jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection sucessfull"+myConn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
