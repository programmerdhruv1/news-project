package com.news.model;

public enum Status {

	Active("Active"), Panding("Panding"), Cancel("Cancel"), NotWork("NotWork"), Hold("Hold"), Delete("Delete");

	private final String displayStatus;

	Status(String displayStatus) {
		this.displayStatus = displayStatus;
	}

	public String getDisplayStatus() {
		return displayStatus;
	}
	
}
