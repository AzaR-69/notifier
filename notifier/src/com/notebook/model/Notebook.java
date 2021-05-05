package com.notebook.model;

public class Notebook {
	private String email;
	private String notebookName;
	private int count;
	public Notebook() {}
	public Notebook(String email, String notebookName) {
		super();
		this.email = email;
		this.notebookName = notebookName;
		count=0;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNotebookName() {
		return notebookName;
	}
	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
