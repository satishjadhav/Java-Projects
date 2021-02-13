package com.design.command;

public class Stock {

	private String name = "ABC";
	private int quantity = 10;
	
	
	public void buy() {
		System.out.println("Stock [ Name: "+name+" ,Quantiy: "+quantity+"] bought");
	}
	
	
	public void sell() {
		System.out.println("Stock [ Name: "+name+" ,Quantiy: "+quantity+"] sold");
	}
}
