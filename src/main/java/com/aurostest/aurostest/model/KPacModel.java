package com.aurostest.aurostest.model;

public class KPacModel {
	private int id;
	private String title;
	private String descript;
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "K-PAC {id = " + id 
				+ ", Title: " + title 
				+ ", Description: " + descript 
				+ ", Creation date: " + date 
				+ "}";
	}
}
