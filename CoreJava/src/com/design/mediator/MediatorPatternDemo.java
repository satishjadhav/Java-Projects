package com.design.mediator;

public class MediatorPatternDemo {

	public static void main(String []args) {
		User robert = new User("Robert");
		User john = new User("John");
		
		robert.sendMessage("hi john!");
		john.sendMessage("hello robert!");
	}
}
