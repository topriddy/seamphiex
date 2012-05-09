package com.topriddy.seamphiex.portlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.CommonConstants;
import com.topriddy.seamphiex.ViewController;

public abstract class Portlet extends HttpServlet implements CommonConstants{
	/*
	 * defines method for portlet service
	 */
	protected abstract void doPortletService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getSession().getAttribute(APP_USER) == null){
			ViewController.switchPage(req, resp, "login");
			return;
		}
		doPortletService(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, resp);
	}

}
