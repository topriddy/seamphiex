package com.topriddy.seamphiex.portlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.ViewController;
import com.topriddy.seamphiex.portlet.Portlet;
import com.topriddy.seamphiex.portlet.PortletState;

public class StudentPortlet extends Portlet {
	private static final long serialVersionUID = -2994125308255165948L;

	private final String PORTLET_NAME = "studentPortlet";
	private final String PORTLET_STATE = "studentPortletState";
	private final String PORTLET_CONTENT_PAGE = "studentPortlet/content";

	@Override
	protected void doPortletService(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PortletState portletState = (PortletState)req.getSession().getAttribute(PORTLET_STATE);
		if(portletState == null){
			portletState = new StudentPortletState();
			req.getSession().setAttribute(PORTLET_STATE, portletState);
		}
		processAction(req, resp);
	}
	
	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String redirect = req.getParameter("redirect");
		String page = PORTLET_CONTENT_PAGE;
		if(action == null || action.equals("")){
			page =  PORTLET_CONTENT_PAGE;
		}else{
			page = redirect;
		}
		
		ViewController.switchPage(req, resp, page);
	}
}