package com.editdatabase.model;

import java.sql.SQLException;

public interface ModifyInterface {
	public int editNotebook(String notebookName,String oldName,String email) throws SQLException;
	public int editNote(String noteName,String oldName,String email) throws SQLException;
}
