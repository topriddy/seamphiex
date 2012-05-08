package com.topriddy.seamphiex.dao;

import com.topriddy.seamphiex.entity.Supervisor;

public class SupervisorDao extends AbstractDao<Supervisor> {
	public SupervisorDao(){
		super(Supervisor.class);
	}
	
	public Supervisor findByUsername(String username) {
		if (username == null || username.equals("")) {
			return null;
		}

		return ofy().query(Supervisor.class).filter("username", username).get();
	}
}