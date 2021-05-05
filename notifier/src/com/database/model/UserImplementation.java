package com.database.model;

import java.sql.SQLException;
import java.sql.*;

public class UserImplementation implements UserDAO {
	private String sql;
	private ResultSet rs;
	private PreparedStatement ps;
	private int n;
	private Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(User u) throws SQLException {
		sql = "INSERT INTO register (userName,phoneNumber,email,password) VALUES(?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPhoneNumber());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		n = ps.executeUpdate();
		return n;
	}

	@Override
	public void delete(String email) throws SQLException {
		sql = "DELETE FROM register WHERE email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.executeUpdate();

	}

	@Override
	public int update(User u,String newPassword) throws SQLException {
		sql = "UPDATE register set userName=?,phoneNumber=?,password=? WHERE email=? AND password=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, u.getUserName());
		ps.setString(2, u.getPhoneNumber());
		ps.setString(3, newPassword);
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		n=ps.executeUpdate();
		return n;

	}

	@Override
	public User getUser(String email) throws SQLException {
		sql = "SELECT * FROM register WHERE email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		User u = new User();
		boolean check = false;
		while (rs.next()) {
			check = true;
			u.setUserName(rs.getString("userName"));
			u.setPhoneNumber(rs.getString("phoneNumber"));
			u.setEmail(rs.getNString("email"));
			u.setPassword(rs.getString("password"));
		}
		if (check) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public boolean loginValidate(String email, String password) throws SQLException {
		sql = "SELECT * FROM register WHERE email=? AND password=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		rs = ps.executeQuery();
		boolean check = rs.next();
		return check;
	}
}
