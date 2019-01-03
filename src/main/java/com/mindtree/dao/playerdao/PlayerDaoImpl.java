package com.mindtree.dao.playerdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mindtree.model.Player;
import com.mindtree.model.Team;
import com.mindtree.utils.MccUtils;



public class PlayerDaoImpl {

	public String addPlayer(Player player) {
		Session session = MccUtils.createConnection();
		Transaction txn = session.beginTransaction(); 
		System.out.println(player);

		session.merge(player);
		txn.commit();
		return "Success";
	}

	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		Session session = MccUtils.createConnection();
		Transaction txn = session.beginTransaction(); 
		
		Query query = session.createQuery("from Player");
		players = query.getResultList();
		System.out.println(players);
		return players;
	}

	public Player getPlayerById(String id) {
		Player player = new Player();	
		Session session = MccUtils.createConnection();
		Transaction txn = session.beginTransaction(); 
		
		Query query = session.createQuery("from Player where id="+id+"");
		player = (Player) query.getSingleResult();
		
		System.out.println(player);
		return player;
	}
	
	public List<Player> getPlayerByStatus(String status) {
		List<Player> players = new ArrayList<>();
		Session session = MccUtils.createConnection();
		Transaction txn = session.beginTransaction(); 
		
		Query query = session.createQuery("from Player where status="+status+"");
		players = query.getResultList();
		System.out.println(players);
		return players;
	}


	
	

}
