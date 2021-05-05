package com.editdatabase.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.model.DatabaseConnection;

public class EditDatabase implements ModifyInterface {
	private String sql;
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection con = DatabaseConnection.getConnection();
	private int n=0,result=0;
	@Override
	public int editNotebook(String notebookName,String oldName,String email) throws SQLException {
		sql="UPDATE notebook_db SET notebookName=? WHERE notebookName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, notebookName);
		ps.setString(2,oldName);
		ps.setString(3, email);
		n=ps.executeUpdate();
		result=0;
		if(n>0) {
			sql="UPDATE newnote SET notebookName=? WHERE notebookName=? AND email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, notebookName);
			ps.setString(2,oldName);
			ps.setNString(3, email);
			result=ps.executeUpdate();
		}
		return result;
	}
	public int editNote(String noteName,String oldName,String email) throws SQLException {
		sql="UPDATE newnote SET noteName=? WHERE noteName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, noteName);
		ps.setString(2,oldName);
		ps.setNString(3, email);
		n=ps.executeUpdate();
		return n;
		
	}

}
