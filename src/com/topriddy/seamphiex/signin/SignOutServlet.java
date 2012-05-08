package com.topriddy.seamphiex.signin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.CommonConstants;
import com.topriddy.seamphiex.ViewController;

public class SignOutServlet extends HttpServlet implements CommonConstants{
	private static final Logger log = Logger.getLogger(SignOutServlet.class.getSimpleName());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.getSession().setAttribute(APP_USER, null);
			ViewController.switchPage(req, resp, "login");
		}catch(Exception ex){
			ex.printStackTrace();
			log.severe(ex.getMessage());
		}
	}

}
