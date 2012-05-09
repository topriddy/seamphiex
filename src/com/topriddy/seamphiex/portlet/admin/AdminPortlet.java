package com.topriddy.seamphiex.portlet.admin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topriddy.seamphiex.ViewController;
import com.topriddy.seamphiex.portlet.Portlet;
import com.topriddy.seamphiex.portlet.PortletState;

public class AdminPortlet extends Portlet{
	private static final long serialVersionUID = -1585639729597117509L;
	
	private final String PORTLET_NAME = "adminPortlet";
	private final String PORTLET_STATE = "adminPortletState";
	private final String PORTLET_CONTENT_PAGE = "adminPortlet/content";
	
	private final Logger log = Logger.getLogger(AdminPortlet.class.getSimpleName());
	
	@Override
	protected void doPortletService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processAction(req, resp);
	}
	
	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminPortletState adminPortletState = AdminPortletState.getInstance(req, resp);
		
		String action = req.getParameter("action");
		String redirect = req.getParameter("redirect");
		String page = PORTLET_CONTENT_PAGE;
		if(action == null || action.equals("")){
			page =  PORTLET_CONTENT_PAGE;
		}else{
			page = redirect;
		}
		
		if(action!= null && action.equals("switchTabs")){
			Integer tab = Integer.parseInt(req.getParameter("tab"));
			if(tab == 1){
				adminPortletState.setCurrentView(AdminPortletState.MANAGE_PROJECT_VIEW); 
			}else if(tab == 2){
				adminPortletState.setCurrentView(AdminPortletState.MANAGE_SUPERVISORS_VIEW);
			}else if(tab == 3){
				adminPortletState.setCurrentView(AdminPortletState.MANAGE_STUDENTS_VIEW);
			}
		}
		ViewController.switchPage(req, resp, page);
	}
}