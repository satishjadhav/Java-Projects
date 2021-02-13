package com.design.flyweight;

public class Circle implements Shape{

	private String color;
	private int x;
	private int y;
	private int radious;
	
	public Circle(String color) {
		this.color = color;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setRadious(int radious) {
		this.radious = radious;
	}
	
	public void draw() {
		System.out.println("Circle: Draw() [Color : "+color+" ,x: "+x+" , y: "+y+", radious: "+radious);
	}
}
