/*
 * 
 * PASINDU VIMANSA KULASOORIYA
 * SPARKX PROGRAM 2020/07/17
 * BASIC PROGRAMMING ASSIGNMENT (CONSOLE BASED CRICKET GAME)
 * 
 */

package com.sparkxcricket.model;

public class Team {

	private String teamName;
	private int playersCount;
	
	
	public Team() {}

	public Team(String teamName, int playersCount) {
		this.teamName = teamName;
		this.playersCount = playersCount;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getPlayersCount() {
		return playersCount;
	}
	public void setPlayersCount(int playersCount) {
		this.playersCount = playersCount;
	}
}
