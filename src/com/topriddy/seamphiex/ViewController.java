package com.topriddy.seamphiex;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewController {
	private static final Logger log = Logger.getLogger(ViewController.class
			.getName());

	public static void switchPage(HttpServletRequest req,
			HttpServletResponse resp, String page) {
		RequestDispatcher dispatcher = req
				.getRequestDispatcher(getPage(page));
		try {
			dispatcher.forward(req, resp);
		} catch (Exception ex) {
			log.severe("Error occured switching page to " + page);
			log.severe(ex.toString());
			ex.printStackTrace();
		}
	}
	
	public static String getPage(String subPath){
		return "/WEB-INF/pages/" + subPath + ".jsp";
	}
}
