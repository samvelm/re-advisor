package com.m4.ra.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextManager {
	private static volatile ApplicationContext context = null;

	private ApplicationContextManager() {
	}

	public static ApplicationContext getContext() {
		initContext();
		return context;
	}
	
	public static void initContext() {
		if (context == null) {
			synchronized (ApplicationContextManager.class) {
				if (context == null) {
					context = new ClassPathXmlApplicationContext("app-config.xml");
				}
			}
		}
	}
}
