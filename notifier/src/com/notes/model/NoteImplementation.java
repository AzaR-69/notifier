package com.notes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.model.DatabaseConnection;

public class NoteImplementation implements NoteDAO {
	private String sql;
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection con = DatabaseConnection.getConnection();

	@Override
	public List<Note> getNotes(String email) throws SQLException {
		sql = "SELECT * FROM newnote WHERE email=?";
		List<Note> notes = new ArrayList<>();
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		while (rs.next()) {
			Note note = new Note();
			note.setEmail(rs.getString("email"));
			note.setNotebookName(rs.getString("notebookName"));
			note.setNoteName(rs.getString("noteName"));
			note.setStartDate(rs.getString("startDate"));
			note.setEndDate(rs.getString("endDate"));
			note.setRemainderDate(rs.getString("remainderDate"));
			note.setStatus(rs.getString("status"));
			note.setTag(rs.getString("tag"));
			note.setDescription(rs.getString("description"));
			notes.add(note);
		}
		return notes;
	}

	@Override
	public List<Note> getNotesByNotebook(String notebookName,String email) throws SQLException {
		List<Note> notes = new ArrayList<>();
		sql = "SELECT * from newnote WHERE notebookName=? AND email=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, notebookName);
		ps.setString(2,email);
		rs=ps.executeQuery();
		while (rs.next()) {
			Note note = new Note();
			note.setEmail(rs.getString("email"));
			note.setNotebookName(rs.getString("notebookName"));
			note.setNoteName(rs.getString("noteName"));
			note.setStartDate(rs.getString("startDate"));
			note.setEndDate(rs.getString("endDate"));
			note.setRemainderDate(rs.getString("remainderDate"));
			note.setStatus(rs.getString("status"));
			note.setTag(rs.getString("tag"));
			note.setDescription(rs.getString("description"));
			notes.add(note);
		}
		return notes;
	}

	@Override
	public int addNote(Note note) throws SQLException {
		sql = "INSERT INTO notifier.newNote (email,notebookName,noteName,startDate,endDate,remainderDate,status,tag,description) VALUES(?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, note.getEmail());
		ps.setString(2, note.getNotebookName());
		ps.setString(3, note.getNoteName());
		ps.setString(4, note.getStartDate());
		ps.setString(5, note.getEndDate());
		ps.setString(6, note.getRemainderDate());
		ps.setString(7, note.getStatus());
		ps.setString(8, note.getTag());
		ps.setString(9, note.getDescription());
		int n = ps.executeUpdate();
		return n;
	}

	@Override
	public void updateCount(String notebookName, String email) throws SQLException {
		sql = "SELECT COUNT(*) from newnote WHERE notebookName=? AND email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, notebookName);
		ps.setString(2, email);
		rs = ps.executeQuery();
		if (rs.next()) {
			int count = 0;
			count = Integer.parseInt(rs.getString(1));
			sql = "UPDATE notebook_db SET count=? WHERE notebookName=? AND email=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, notebookName);
			ps.setString(3, email);
			ps.executeUpdate();
		}
	}

	@Override
	public boolean countCheck(String notebookName) throws SQLException {
		sql = "SELECT * FROM notebook_db WHERE notebookName=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, notebookName);
		rs = ps.executeQuery();
		boolean check = rs.next();
		return check;
	}

	@Override
	public int deleteNote(String noteName, String email) throws SQLException {
		sql = "DELETE FROM newnote WHERE noteName=? AND email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, noteName);
		ps.setString(2, email);
		int n = ps.executeUpdate();
		return n;
	}

}
