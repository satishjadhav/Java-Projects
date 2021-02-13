package com.design.frontcontroller;

public class FrontControllerPatternDemo {

	public static void main(String []args) {
		FrontController controller = new FrontController();
		controller.dispatchRequest("HOME");
		controller.dispatchRequest("STUDENT");
	}
}
