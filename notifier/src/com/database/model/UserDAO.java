package com.database.model;

import java.sql.SQLException;

public interface UserDAO {
	public int add(User u) throws SQLException;

	public void delete(String email) throws SQLException;

	public int update(User u,String newPassword) throws SQLException;

	public User getUser(String email) throws SQLException;

	public boolean loginValidate(String email, String password) throws SQLException;
}
