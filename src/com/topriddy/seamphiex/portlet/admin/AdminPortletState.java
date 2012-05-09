package com.topriddy.seamphiex.portlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.portlet.PortletState;

public class AdminPortletState extends PortletState {
	private static final long serialVersionUID = -5665138332051237140L;

	private final static String PORTLET_NAME = "adminPortlet";
	private final static String PORTLET_STATE = "adminPortletState";
	private final static String PORTLET_CONTENT_PAGE = "adminPortlet/content";
	
	public static final String DEFAULT_VIEW = "defaultView";
	
	public static final String MANAGE_PROJECT_VIEW = "manageProjectsView";
	public static final String MANAGE_SUPERVISORS_VIEW = "manageSupervisorsView";
	public static final String MANAGE_STUDENTS_VIEW = "manageStudentsView";
	private String currentView;

	public AdminPortletState() {
		this.currentView = MANAGE_STUDENTS_VIEW;
	}

	
	//getters and setters
	public String getCurrentView() {
		return currentView;
	}

	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}

	public String getDEFAULT_VIEW() {
		return DEFAULT_VIEW;
	}
	
	
	public static AdminPortletState getInstance(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AdminPortletState portletState = (AdminPortletState)req.getSession().getAttribute(PORTLET_STATE);
		if(portletState == null){
			portletState = new AdminPortletState();
			req.getSession().setAttribute(PORTLET_STATE, portletState);
		}
		return portletState;
	}
}