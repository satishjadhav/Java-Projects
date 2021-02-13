package com.design.bridge;

public class RedCircle implements DrawAPI{

	public void drawCircle(int radius,int x,int y) {
		System.out.println("Drawing Circle [ color red, redius: "+radius+",x: "+x+", "+y+"]");
	}
}
