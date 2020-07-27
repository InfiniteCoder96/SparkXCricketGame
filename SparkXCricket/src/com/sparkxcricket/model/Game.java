package com.sparkxcricket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
	// initializing Scanner object
	private Team team01; // Declaring team01 object
	private Team team02; // initializing team02 object
	
	private final static int PLAYER_COUNT = 6; // Initializing player count to 6
	private final static int TEAM_COUNT = 2; // Initializing team count to 2
	private static Map<String, ArrayList<Integer>> scoreBoard; // Declaring scoreboard hash map. This is used for store runs of each player of each team 
	private static Map<String, String> gameDetails; // Declaring game details hash map. This is used for store details of the game
	
	public Game() { // Initializing game objects and variables
		team01 = new Team(); // initializing team01 object
		team02 = new Team(); // initializing team02 object
		scoreBoard = new HashMap<String, ArrayList<Integer>>(); // initializing scoreboard object
		gameDetails = new HashMap<String, String>(); // initializing game_details object
	}

	public Team getTeam01() {
		return team01;
	}

	public void setTeam01(Team team01) {
		this.team01 = team01;
	}

	public Team getTeam02() {
		return team02;
	}

	public void setTeam02(Team team02) {
		this.team02 = team02;
	}

	public Map<String, ArrayList<Integer>> getScoreboard() {
			return scoreBoard;
	}

	public void setScoreboard(Map<String, ArrayList<Integer>> scoreboard) {
			Game.scoreBoard = scoreboard;
	}

	public Map<String, String> getGameDetails() {
		return gameDetails;
	}

	public void setGameDetails(Map<String, String> game_details) {
		Game.gameDetails = game_details;
	}

	public int getPlayerCount() {
		return PLAYER_COUNT;
	}

	public int getTeamCount() {
		return TEAM_COUNT;
	}
}
