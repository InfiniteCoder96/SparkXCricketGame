/*
 * 
 * PASINDU VIMANSA KULASOORIYA
 * SPARKX PROGRAM 2020/07/17
 * BASIC PROGRAMMING ASSIGNMENT (CONSOLE BASED CRICKET GAME)
 * 
 */

package com.sparkxcricket.model;

import java.util.Random;
import java.util.Scanner;

public class Player {

	private int totalRuns;
	
	public Player() {}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	public void calculateRuns(int run) {
		setTotalRuns(getTotalRuns() + run);
	}
	
	public int play(int PLAYER_COUNT, int playerNo, int teamNo, int bowls, Random rand,Scanner scan, int totMarks[]) {
		Boolean out = false;
		Boolean over = false;
		String wicketType = null;
		
		while(!over && !out) {
			System.out.print("\nPlayer " + (playerNo + 1) + " press 'B' to Bat: ");
			String bat = scan.nextLine();
			int runs = -1;
			
			if(bat.equalsIgnoreCase("B")) {
				runs = rand.nextInt(9);
				if(runs == 6) { // 6 runs
					System.out.println("Hooooray! " + runs + " Runs !!!");
					
					this.calculateRuns(runs);
					
					totMarks[teamNo] += runs;
					
				}
				else if(runs == 4) { // 4 runs
					System.out.println("Hooooray! " + runs + " Runs !!!");
					
					this.calculateRuns(runs);
					
					totMarks[teamNo] += runs;
					
				}
				else if(runs == 7 ||  runs == 8) {// 7 and 8 are wicket
					System.out.println("OOOPS! You got out");
					
					out = true;
					
					// two out types
					if(runs == 7) {
						wicketType = "Bowled Out";
					}
					else {
						wicketType = "Caught Out";
					}
				} 
				else {// normal runs ex: 0,1,2...
					System.out.println(runs + " Runs !!");
					
					this.calculateRuns(runs); // calculates run of the player
					totMarks[teamNo] += runs;
				}
				
				if(totMarks[1] > totMarks[0]) {
					break; // break if team 02 scores greater than team 01
				}
				
				bowls--; // decreasing bowls count
				
				if(bowls < 1) { // if bowls over
					over = true;
					wicketType = "Over";
				}
			}		
		}
		
		if(wicketType != null) {
			System.out.println("Player " + (playerNo+1) + " Runs:" + this.getTotalRuns() + " | " + wicketType + " | Bowls remaining:" + bowls + " | Wickets remaining: " + (PLAYER_COUNT - (playerNo+1)));
			
			if(wicketType.equals("Over")) {
				bowls = -1; // break if bowls over
			}
		}
		else {
			System.out.println("Player " + (playerNo+1) + " Runs:" + this.getTotalRuns() + " | Bowls remaining:" + bowls + " | Wickets remaining: " + (PLAYER_COUNT - (playerNo+1)) );
			bowls = -2; // break if team 02 wins
		}
		return bowls;
	}
}
