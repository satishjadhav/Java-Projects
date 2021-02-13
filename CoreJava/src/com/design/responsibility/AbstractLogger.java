package com.design.responsibility;

public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	protected AbstractLogger nextAbstractLogger;
	
	public void setNextLogger(AbstractLogger nextAbstractLogger) {
		this.nextAbstractLogger = nextAbstractLogger;
	}
	
	public void logMessage(int level,String message) {
		if(this.level<=level) {
			write(message);
		}
		if(nextAbstractLogger!=null) {
			nextAbstractLogger.logMessage(level, message);
		}
	}
	abstract protected void write(String message);
}
