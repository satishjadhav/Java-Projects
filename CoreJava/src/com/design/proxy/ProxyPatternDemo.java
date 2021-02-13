package com.design.proxy;

public class ProxyPatternDemo {

	public static void main(String []args) {
		Image image = new ProxyImage("fileImage.jpeg");
		
		image.display();
		System.out.println("");
		
		image.display();
	}
}
