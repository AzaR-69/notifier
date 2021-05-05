package com.database.model;

import java.sql.*;

public class DatabaseConnection {
	private static Connection con = null;
	static {
		String url = "jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
