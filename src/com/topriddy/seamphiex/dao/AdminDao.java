package com.topriddy.seamphiex.dao;

import com.topriddy.seamphiex.entity.Admin;

public class AdminDao extends AbstractDao<Admin> {
	public AdminDao() {
		super(Admin.class);
	}

	public Admin findByUsername(String username) {
		if (username == null || username.equals("")) {
			return null;
		}

		return ofy().query(Admin.class).filter("username", username).get();
	}
}
