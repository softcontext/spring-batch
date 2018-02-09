package com.example.demo.quartz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

	private static AppLogger appLogger = null;
	private static Logger logger = null;
	private static int stackTraceLevel = 4;

	private AppLogger() {
		logger = LoggerFactory.getLogger(AppLogger.class);
	}

	public static AppLogger getInstance() {
		if (appLogger == null) {
			synchronized (AppLogger.class) {
				if (appLogger == null) {
					appLogger = new AppLogger();
				}
			}
		}
		return appLogger;
	}

	private String getClassName() {
		String className = AppConstants.BLANK;
		try {
			className = Thread.currentThread().getStackTrace()[stackTraceLevel].getClassName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return className;
	}

	private String getMethodName() {
		String methodName = AppConstants.BLANK;
		try {
			methodName = Thread.currentThread().getStackTrace()[stackTraceLevel].getMethodName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return methodName;
	}

	private String getBaseMessage(String message) {
		String logMsg = getClassName() + AppConstants.COLON + getMethodName() + AppConstants.DASH + message;
		return logMsg;
	}

	public void entry() {
		logger.info(getBaseMessage(AppConstants.ENTRY));
	}

	public void exit() {
		logger.info(getBaseMessage(AppConstants.EXIT));
	}

	public void info(String message) {
		logger.info(getBaseMessage(message));
	}

	public void info(String message, Object... objects) {
		logger.info(getBaseMessage(message), objects);
	}

	public void warn(String message) {
		logger.warn(getBaseMessage(message));
	}

	public void warn(String message, Object... objects) {
		logger.warn(getBaseMessage(message), objects);
	}

	public void warn(String message, Throwable t) {
		logger.warn(getBaseMessage(message), t);
	}

	public void debug(String message) {
		logger.debug(getBaseMessage(message));
	}

	public void debug(String message, Object... objects) {
		logger.debug(getBaseMessage(message), objects);
	}

	public void debug(String message, Throwable t) {
		logger.debug(getBaseMessage(message), t);
	}

	public void error(String message) {
		logger.error(getBaseMessage(message));
	}

	public void error(String message, Object... objects) {
		logger.error(getBaseMessage(message), objects);
	}

	public void error(String message, Throwable t) {
		logger.error(getBaseMessage(message), t);
	}

}
