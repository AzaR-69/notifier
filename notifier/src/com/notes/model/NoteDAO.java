package com.notes.model;
import java.sql.SQLException;
import java.util.List;
public interface NoteDAO {
	public List<Note> getNotes(String email) throws SQLException;
	public List<Note> getNotesByNotebook(String notebookName,String email) throws SQLException;
	public int addNote(Note note) throws SQLException;
	public boolean countCheck(String notename) throws SQLException;
	public void updateCount(String notebookName,String email) throws SQLException;
	public int deleteNote(String noteName,String email) throws SQLException;
}
