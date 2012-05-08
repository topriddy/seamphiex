package com.topriddy.seamphiex.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.topriddy.seamphiex.CommonConstants;
import com.topriddy.seamphiex.ViewController;
import com.topriddy.seamphiex.entity.AppUser;
import com.topriddy.seamphiex.entity.Role;

public class SignInServlet extends HttpServlet implements CommonConstants {
	private static Logger log = Logger.getLogger(SignInServlet.class.getName());
	private final String DEFAULT_ADMIN = "admin";
	private final String DEFAULT_ADMIN_PASSWORD = "password";
	private final String DEFAULT_STUDENT = "ify";
	private final String DEFAULT_STUDENT_PASSWORD = "password";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("Sign In Servlet Called...");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");

		log.info("Username is: " + username);
		log.info("Password is: " + password);
		log.info("Role is: " + role);

		List<String> errorList = new ArrayList<String>();
		req.getSession().setAttribute("errorList", errorList);
		if (username == null || username.equals("")) {

		}

		doSignIn(username, password, role, req, resp);
	}

	private void doSignIn(String username, String password, String role,
			HttpServletRequest req, HttpServletResponse resp) {
		if (role.equalsIgnoreCase(Role.ADMIN.toString())) {
			log.info("Selected Role is ADMIN");
			signInAsAdmin(username, password, req, resp);
		} else if (role.equalsIgnoreCase(Role.STUDENT.toString())) {
			log.info("Selected Role is Student");
			signInAsStudent(username, password, req, resp);
		} else {
			failedSignIn(req, resp);
		}
	}

	private void signInAsAdmin(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		if(!(username.equalsIgnoreCase(DEFAULT_ADMIN) && password.equalsIgnoreCase(DEFAULT_ADMIN_PASSWORD))){
			failedSignIn(req, resp);
		}
		HttpSession session = req.getSession();
		AppUser appUser = new AppUser(username, password);
		session.setAttribute(APP_USER, appUser);
		ViewController.switchPage(req, resp, "admin/welcomeAdmin");
	}

	private void signInAsStudent(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		if(!(username.equalsIgnoreCase(DEFAULT_STUDENT) && password.equalsIgnoreCase(DEFAULT_STUDENT_PASSWORD))){
			failedSignIn(req, resp);
		}
		
		HttpSession session = req.getSession();
		AppUser appUser = new AppUser(username, password);
		session.setAttribute(APP_USER, appUser);
		ViewController.switchPage(req, resp, "student/welcomeStudent");
	}

	private void failedSignIn(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ViewController.switchPage(req, resp, "login");
		} catch (Exception ex) {
		}
	}
}