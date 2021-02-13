package com.design.mediator;

public class User {

	private String name;
	
	public void setMessage(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}
