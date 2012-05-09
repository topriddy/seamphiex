package com.topriddy.seamphiex.signin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.CommonConstants;
import com.topriddy.seamphiex.ViewController;
import com.topriddy.seamphiex.dao.AdminDao;
import com.topriddy.seamphiex.dao.StudentDao;
import com.topriddy.seamphiex.dao.SupervisorDao;
import com.topriddy.seamphiex.entity.Admin;
import com.topriddy.seamphiex.entity.Role;
import com.topriddy.seamphiex.entity.Student;
import com.topriddy.seamphiex.entity.Supervisor;

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
//		String action = req.getParameter("action");
//		String redirect = req.getParameter("redirect");

		log.info("Username is: " + username);
		log.info("Password is: " + password);
		log.info("Role is: " + role);
		log.info("redirect: " + req.getParameter("redirect"));

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
		}else if (role.equalsIgnoreCase(Role.SUPERVISOR.toString())) {
			log.info("Selected Role is Supervisor");
			signInAsSupervisor(username, password, req, resp);
		} else {
			failedSignIn(req, resp);
		}
	}

	private void signInAsAdmin(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.findByUsername(username);
		if(admin == null || !admin.getPassword().equals(password)){
			failedSignIn(req, resp);
		}
		req.getSession().setAttribute(APP_USER, admin);
		try{
			req.getRequestDispatcher("/AdminPortlet").forward(req, resp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void signInAsSupervisor(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		SupervisorDao supervisorDao = new SupervisorDao();
		Supervisor supervisor = supervisorDao.findByUsername(username);
		if(supervisor == null || !supervisor.getPassword().equals(password)){
			failedSignIn(req, resp);
		}
		req.getSession().setAttribute(APP_USER, supervisor);
		ViewController.switchPage(req, resp, "supervisor/welcomeSupervisor");
	}

	private void signInAsStudent(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.findByUsername(username);
		if(student == null || !student.getPassword().equals(password)){
			failedSignIn(req, resp);
		}
		req.getSession().setAttribute(APP_USER, student);
		try{
			req.getRequestDispatcher("/StudentPortlet").forward(req, resp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void failedSignIn(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ViewController.switchPage(req, resp, "login");
		} catch (Exception ex) {
		}
	}
}