package com.aurostest.aurostest.model;

public class KPacSetModel {
	private int idSet;
	private String title;

	public int getIdSet() {
		return idSet;
	}

	public void setIdSet(int idSet) {
		this.idSet = idSet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "K-PAC SET {id = " + idSet 
				+ ", Title: " + title 
				+ "}";
	}
}
