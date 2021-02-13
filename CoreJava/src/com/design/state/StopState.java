package com.design.state;

public class StopState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Palyer is in stop state");
		context.setState(this);
	} 
	
	public String toString() {
		return "Stop state";
	}

}
