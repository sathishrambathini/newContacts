package com.agilecrm.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcCon {
	public static Connection con = null;
	public static Connection getConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/training";
			String user = "root";
			String password = "root123";
			System.out.println("hello");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
