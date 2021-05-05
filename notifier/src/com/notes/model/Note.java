package com.notes.model;

public class Note {
	private String email;
	private String notebookName;
	private String noteName;
	private String startDate;
	private String endDate;
	private String remainderDate;
	private String status;
	private String tag;
	private String description;
	public Note() {}
	public Note(String email, String notebookName, String noteName, String startDate, String endDate,
			String remainderDate, String status, String tag, String description) {
		super();
		this.email = email;
		this.notebookName = notebookName;
		this.noteName = noteName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remainderDate = remainderDate;
		this.status = status;
		this.tag = tag;
		this.description = description;
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
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRemainderDate() {
		return remainderDate;
	}
	public void setRemainderDate(String remainderDate) {
		this.remainderDate = remainderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
