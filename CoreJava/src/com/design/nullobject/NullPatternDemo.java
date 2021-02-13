package com.design.nullobject;

public class NullPatternDemo {

	public static void main(String []args) {
		
		AbstractCustomer abstractCustomer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer abstractCustomer2 = CustomerFactory.getCustomer("Bob");
		AbstractCustomer abstractCustomer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer abstractCustomer4 = CustomerFactory.getCustomer("Laura");
		
		
		System.out.println("Customers");
		System.out.println(abstractCustomer1.getName());
		System.out.println(abstractCustomer2.getName());
		System.out.println(abstractCustomer3.getName());
		System.out.println(abstractCustomer4.getName());
		
	}
}
