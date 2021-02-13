package com.design.bridge;

public class GreenCircle implements DrawAPI {

	public void drawCircle(int radius,int x,int y)
	{
		System.out.println("Drawing Circle[ color: green, redius: "+radius+",x: "+x+", y: "+y+"]");
	}
}
