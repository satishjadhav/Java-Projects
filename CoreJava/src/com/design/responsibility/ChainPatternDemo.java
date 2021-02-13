package com.design.responsibility;

public class ChainPatternDemo {

	private static AbstractLogger getChainOfLogger() {
		AbstractLogger abstractLoggerError = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger abstractLoggerFile = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger abstractLoggerConsole = new ConsoleLogger(AbstractLogger.INFO);
		
		abstractLoggerError.setNextLogger(abstractLoggerFile);
		abstractLoggerFile.setNextLogger(abstractLoggerConsole);
		
		return abstractLoggerError;
	}
	
	public static void main(String []args) {
		AbstractLogger abstractLogger = getChainOfLogger();
		
		abstractLogger.logMessage(AbstractLogger.INFO, "This is an information");
		
		abstractLogger.logMessage(AbstractLogger.DEBUG, "This is an debug level information");
		
		abstractLogger.logMessage(AbstractLogger.ERROR, "This is error information");
	}
}
