package com.design.strategy;

public class StrategyPatternDemo {
	public static void main(String []args)
	{
		Context contextAdd = new Context(new OperationAdd());
		System.out.println("10+5: "+contextAdd.executeStrategy(10, 5));
		
		Context contextSub = new Context(new OperationSubstract());
		System.out.println("10-5: "+contextSub.executeStrategy(10, 5));
		
		Context contextMul = new Context(new OperationMultiply());
		System.out.println("10*5: "+contextMul.executeStrategy(10, 5));
	}
	
}
