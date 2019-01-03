package com.mindtree.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.dao.playerdao.PlayerDaoImpl;
import com.mindtree.dao.teamdao.TeamDaoImpl;
import com.mindtree.model.Player;
import com.mindtree.model.Team;

@Controller
public class MainController {
	
	PlayerDaoImpl playerDaoObj = new PlayerDaoImpl();
	TeamDaoImpl teamDaoObj = new TeamDaoImpl();
	
	
	@RequestMapping(value = "/index")
	public ModelAndView indexPage()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/addPlayer")
	public ModelAndView toAddPlayer()
	{
		return new ModelAndView("addplayer");
	}
	
	@RequestMapping(value ="addPlayer", method = RequestMethod.POST)
	public ModelAndView addPlayer(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView();
		Player player = new Player();
		player.setId(request.getParameter("id"));
		player.setName(request.getParameter("name"));
		player.setType(request.getParameter("type"));
		player.setAge(Integer.parseInt(request.getParameter("age")));
		player.setStatus("available");
		player.setBattingAvg(Double.parseDouble(request.getParameter("batAvg")));
		player.setBowlingAvg(Double.parseDouble(request.getParameter("bowlAvg")));	
		
		String message = playerDaoObj.addPlayer(player);
		return new ModelAndView("showplayers","message","added successfully");
	}
	
	@RequestMapping(value="/getAllPlayers", method=RequestMethod.GET)
	public ModelAndView displayUsers(HttpServletRequest request, HttpServletResponse response)
	{
		List<Player> plist= new ArrayList<>();
		plist = playerDaoObj.getAllPlayers();
		
		return new ModelAndView("showplayers","list", plist);	
	}
	
	@RequestMapping(value = "/addTeam")
	public ModelAndView toAddTeam()
	{
		List<Player> plist= new ArrayList<>();
		plist = playerDaoObj.getAllPlayers();		
		return new ModelAndView("addteam","list",plist);
	}
	
	
	@RequestMapping(value = "/submitPlayers", method = RequestMethod.POST)
	public void submitTeamPlayers(HttpServletRequest request, HttpServletResponse response)
	{
		
		String[] players = request.getParameterValues("teamPlayers");
		for (int i = 0; i < players.length; i++) {
			
			Player player;
			player = playerDaoObj.getPlayerById(players[i]);
			player.setStatus("Booked");
			playerDaoObj.addPlayer(player);	
		}
		//return new ModelAndView("showteams");
	}
	
	
	@RequestMapping(value ="addTeam", method = RequestMethod.POST)
	public ModelAndView addTeam(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView();

		Team team = new Team();
		
		team.setId(Integer.parseInt(request.getParameter("id")));
		team.setName(request.getParameter("name"));
		team.setState(request.getParameter("type"));
		
		String msg = teamDaoObj.addTeam(team);
		return new ModelAndView("showteams","message","added successfully");
	}
}
