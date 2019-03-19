package com.spring.security.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestApp {
	public static void main(String[] args) {
		/*
		 * we have to insert these encrypted password inside users table for password field.
		 * 
		*/
		System.out.println(new BCryptPasswordEncoder().encode("admin@123"));

		System.out.println(new BCryptPasswordEncoder().encode("user@123"));

		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false",
		 * "root","root"); System.out.println(con); } catch (ClassNotFoundException |
		 * SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
}
