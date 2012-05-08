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
//		try {
//			resp.sendRedirect("/WEB-INF/pages/" + page + ".jsp");
//		} catch (Exception ex) {
//			log.severe("Error occured switching page to " + page);
//			log.severe(ex.getMessage());
//		}
		
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (Exception ex) {
			log.severe("Error occured switching page to " + page);
			log.severe(ex.toString());
			ex.printStackTrace();
		}
	}
}
