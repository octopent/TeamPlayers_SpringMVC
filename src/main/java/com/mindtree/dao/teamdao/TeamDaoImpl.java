package com.mindtree.dao.teamdao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.model.Team;
import com.mindtree.utils.MccUtils;

public class TeamDaoImpl {
	public String addTeam(Team team) {
		Session session = MccUtils.createConnection();
		Transaction txn = session.beginTransaction(); 
		session.save(team);
		txn.commit();
		return "Success";
	}
}
