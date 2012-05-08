package com.topriddy.seamphiex;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.util.logging.Logger;

public class ApplicationContext implements ServletContextListener {
	private static final Logger log = Logger.getLogger(ApplicationContext.class.getName());
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		log.info("Servlet Context Listener destroyed...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		log.info("Servlet Context Listener initialized...");
		DataInitialiser.initWithDefaultData();
		
	}

}