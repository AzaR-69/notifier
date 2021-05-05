package com.notebook.model;
import java.sql.SQLException;
import java.util.List;
public interface NotebookDAO {
	public List<Notebook> getNotebooks(String email) throws SQLException;
	public int addNotebook(Notebook notebook) throws SQLException;
	public String getNotebook(String noteName,String email) throws SQLException;
	public int deleteNotebook(String notebookName,String email) throws SQLException;
	public void deleteNotes(String notebookName,String email) throws SQLException;
}
