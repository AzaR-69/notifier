package com.notebook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.model.DatabaseConnection;

public class NotebookImplementation implements NotebookDAO {
	private String sql;
	private ResultSet rs;
	private PreparedStatement ps;
	private int n;
	private Connection con = DatabaseConnection.getConnection();

	@Override
	public int addNotebook(Notebook notebook) throws SQLException {
		sql="INSERT INTO notifier.notebook_db (email,notebookName) VALUES(?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, notebook.getEmail());
		ps.setString(2, notebook.getNotebookName());
		n=ps.executeUpdate();
		return n;
	}

	@Override
	public String getNotebook(String noteName, String email) throws SQLException {
		sql="SELECT notebookName FROM newnote WHERE noteName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, noteName);
		ps.setString(2, email);
		rs=ps.executeQuery();
		String notebookName="";
		if(rs.next()) {
			notebookName=rs.getString("notebookName");
		}
		return notebookName;
	}

	@Override
	public int deleteNotebook(String notebookName, String email) throws SQLException {
		sql="DELETE FROM notebook_db WHERE notebookName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, notebookName);
		ps.setString(2, email);
		n=ps.executeUpdate();
		return n;
	}

	@Override
	public void deleteNotes(String notebookName, String email) throws SQLException {
		sql="DELETE FROM newnote WHERE notebookName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setNString(1, notebookName);
		ps.setNString(2, email);
		ps.executeUpdate();
	}

	@Override
	public List<Notebook> getNotebooks(String email) throws SQLException {
		List<Notebook> notebooks=new ArrayList<>();
		sql="SELECT * from notebook_db where email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, email);
		rs=ps.executeQuery();
		while(rs.next()) {
			Notebook notebook=new Notebook();
			notebook.setEmail(rs.getString("email"));
			notebook.setNotebookName(rs.getString("notebookName"));
			notebook.setCount(rs.getInt("count"));
			notebooks.add(notebook);
		}
		return notebooks;
	}

}
