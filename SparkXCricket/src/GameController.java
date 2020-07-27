/*
 * 
 * PASINDU VIMANSA KULASOORIYA
 * SPARKX PROGRAM 2020/07/17
 * BASIC PROGRAMMING ASSIGNMENT (CONSOLE BASED CRICKET GAME)
 * 
 */

// Importing necessary libraries
import java.util.*;

import com.sparkxcricket.model.Game;
import com.sparkxcricket.model.Player;

public class GameController { // Start main class
	
	private static Game cricketGame;
	private static Player player; // Declaring player object	
	private static Scanner scan = new Scanner(System.in); // initializing scan object
	private static Random rand = new Random();// initializing random number generator
	private static int totMarks[] = new int[2]; // Declaring integer array tot_marks. This is used for store total runs of each team
	private static int remainBowls; // Declaring integer variable remain_bowls. This is used for store remaining bowls each team has
	
	/*tossing coin function ex:head or tail*/
	private static void tossingCoin() throws InterruptedException {
		System.out.println("\nPlease gather " + cricketGame.getTeam01().getTeamName() + " team captain and " + cricketGame.getTeam02().getTeamName() + " team captain to toss the coin...");
		System.out.print(cricketGame.getTeam01().getTeamName() + " captain, Please make the call");
		
		System.out.println("\n<<<<< Enter 'H' for Select Head     >>>>>");
		System.out.println("<<<<< Enter 'T' for Select Tail     >>>>>\n");
		
		System.out.print("Your option: ");
		String toss_call_str = scan.nextLine();
		
		Boolean toss_bool = null;
		
		if(toss_call_str.equalsIgnoreCase("H")) { // validate user input and random boolean for head 
			toss_bool = true;
		}
		else if(toss_call_str.equalsIgnoreCase("T")) { // validate user input and random boolean for tail
			toss_bool = false;
		}
		else { // validate user input 
			System.out.println("\nInvalid Input..Try again!!!");
			tossingCoin();
		}
		System.out.println("\nTossing coin....Please wait");
		Thread.sleep(3000);
		
		electSide(toss_bool); // calling elecSide function
	}// end tossing coin function
	
	/*side selection function ex:batting or bowling*/
	private static void electSide(Boolean toss_bool) {
		Boolean toss = rand.nextBoolean(); // generate random boolean
		
		if(toss.equals(toss_bool)) {
			System.out.print("\n" + cricketGame.getTeam01().getTeamName() + " team captain won the toss...\nPlease select Batting or bowling");
			
			System.out.println("\n<<<<< Enter 'T' for Select Batting     >>>>>");
			System.out.println("<<<<< Enter 'B' for Select Bowling     >>>>>\n");
			
			System.out.print("Your option: ");
			String elect = scan.nextLine(); // get user input
			
			cricketGame.getGameDetails().put("WONTOSS", cricketGame.getTeam01().getTeamName()); // save toss won team in game_details hash map
			
			if(elect.equalsIgnoreCase("T")) { // validate user input with generated random boolean for batting
				System.out.println("\n" + cricketGame.getTeam01().getTeamName() + " team elected to bat first.");
				cricketGame.getGameDetails().put("ELECTEDSIDE", "Batting");
				cricketGame.getGameDetails().put("FIRSTBAT", cricketGame.getTeam01().getTeamName());
				cricketGame.getGameDetails().put("SECONDBAT", cricketGame.getTeam02().getTeamName());
			}
			else if(elect.equalsIgnoreCase("B")){ // validate user input with generated random boolean for bowling
				System.out.println("\n" + cricketGame.getTeam01().getTeamName() + " team elected to bowl first.");
				cricketGame.getGameDetails().put("ELECTEDSIDE", "Bowling");
				cricketGame.getGameDetails().put("FIRSTBAT", cricketGame.getTeam02().getTeamName());
				cricketGame.getGameDetails().put("SECONDBAT", cricketGame.getTeam01().getTeamName());
			}
			else {  // validate user input with generated random boolean for invalid input
				System.out.println("\nInvalid Input..Try again!!!");
				electSide(toss_bool);
			}
		}
		else {
			System.out.print("\n" + cricketGame.getTeam02().getTeamName() + " team captain won the toss...\nPlease select Batting or bowling");
			
			System.out.println("\n<<<<< Enter 'T' for Select Batting     >>>>>");
			System.out.println("<<<<< Enter 'B' for Select Bowling     >>>>>\n");
			
			System.out.print("Your option: ");
			String elect = scan.nextLine();
			
			cricketGame.getGameDetails().put("WONTOSS", cricketGame.getTeam02().getTeamName());
			
			if(elect.equals("T")) {
				System.out.println("\n" + cricketGame.getTeam02().getTeamName() + " team elected to bat first.");
				cricketGame.getGameDetails().put("ELECTEDSIDE", "Batting");
				cricketGame.getGameDetails().put("FIRSTBAT", cricketGame.getTeam02().getTeamName());
				cricketGame.getGameDetails().put("SECONDBAT", cricketGame.getTeam01().getTeamName());
			}
			else if(elect.equals("B")){
				System.out.println("\n" + cricketGame.getTeam02().getTeamName() + " team elected to bowl first.");
				cricketGame.getGameDetails().put("ELECTEDSIDE", "Bowling");
				cricketGame.getGameDetails().put("FIRSTBAT", cricketGame.getTeam01().getTeamName());
				cricketGame.getGameDetails().put("SECONDBAT", cricketGame.getTeam02().getTeamName());
			}
			else {
				System.out.println("\nInvalid Input..Try again!!!");
				electSide(toss_bool);
			}
		}
	}// end side selection function
	
	/*show score board function*/
	private static void showScoreBoard() throws InterruptedException {
		System.out.println("\n****** SPARK X CRICKET 2020 LOADING ******\n");
		Thread.sleep(2000);
		
		System.out.println("\n!!!!!!!!!!!!!!! SCOREBOARD !!!!!!!!!!!!!!\n");
		
		cricketGame.getScoreboard().put(cricketGame.getGameDetails().get("SECONDBAT"), cricketGame.getScoreboard().get("Team2"));
		cricketGame.getScoreboard().put(cricketGame.getGameDetails().get("FIRSTBAT"), cricketGame.getScoreboard().get("Team1"));
		
		
		cricketGame.getScoreboard().remove("Team1");
		cricketGame.getScoreboard().remove("Team2");
		
		for (String name: cricketGame.getScoreboard().keySet()){
			
            String key = name.toString();
            
            ArrayList<Integer> value = cricketGame.getScoreboard().get(name);
            
            System.out.println("\n------- Team " + key + " scores -------\n");
           
            	
            for(int i = 0; i < value.size(); i++) {   
                   System.out.print("Player " + (i+1) + ":" + value.get(i) + "\n");
            } 
		} 
		
		if(totMarks[0] > totMarks[1]) {
			System.out.println("\n" + cricketGame.getGameDetails().get("FIRSTBAT") + " team Wins by " + (totMarks[0] - totMarks[1]) + " Runs");
		}
		else if(totMarks[1] > totMarks[0]){
			System.out.println("\n" + cricketGame.getGameDetails().get("SECONDBAT") + " team Wins by " + (totMarks[1] - totMarks[0]) + " Runs");
		}
		System.out.println("\n****** GAME ENDED ******\n");
		Thread.sleep(5000);
	}// end show score board function
	
	/*play function*/
	private static void play() throws InterruptedException {
		for(int j = 0;j < cricketGame.getTeamCount(); j++) { // run till all teams finished playing 
			
			int bowls = 15; // initializing bowl count as 15 (5 overs, 3 bowls per over)
			Boolean over = false; // initializing over state as false;
			ArrayList<Integer> scores = new ArrayList<>();
			Boolean hasWinner = false; // initializing hasWinner state as false
			
			if(j == 0) {
				System.out.println("\nTeam " + cricketGame.getGameDetails().get("FIRSTBAT") + " Please Ready To Bat!!!");
				Thread.sleep(3000);
				System.out.println("\nTeam " + cricketGame.getGameDetails().get("FIRSTBAT") + " is batting...");
			}
			else {
				System.out.println("\nTeam " + cricketGame.getGameDetails().get("SECONDBAT") + " Please Ready To Bat!!!");
				Thread.sleep(3000);
				System.out.println("\nTeam " + cricketGame.getGameDetails().get("SECONDBAT") + " is batting...");
			}
			
			for(int i = 0;i < cricketGame.getPlayerCount(); i++) { // run till all players finished playing			
				player = new Player();
				
				bowls = player.play(cricketGame.getPlayerCount(), i, j, bowls, rand, scan, totMarks);
				
				scores.add(player.getTotalRuns()); // get total runs of each player and add it to scores array list
				
				if(bowls == -1) {
					break;
				}
				else if(bowls == -2) {
					hasWinner = true;
					break;
				}
			}
			
			cricketGame.getScoreboard().put("Team" + (j+1), scores);
			
			if(j == 0) {
				System.out.println("\nTotal Runs " + cricketGame.getGameDetails().get("FIRSTBAT") + " Team: " + totMarks[j]);
			}
			else {
				System.out.println("\nTotal Runs " + cricketGame.getGameDetails().get("SECONDBAT") + " Team: " + totMarks[j]);
			}
			
			remainBowls = bowls;
			
			if(hasWinner) {
				break; // beak if hasWinner state true
			}
		}
	} // end play function
	
	/*show main menu function*/
	private static String showMainMenu() throws InterruptedException { 
		System.out.println("\n****** SPARK X CRICKET 2020 LOADING ******\n");
		Thread.sleep(2000);
		
		System.out.println("<<<<< WELCOME TO SPARK X CRICKET 2020 >>>>>");
		Thread.sleep(2000);
		
		System.out.println("<<<<<        Main Menu      >>>>>");
		System.out.println("<<<<< Enter 'P' to Play     >>>>>");
		System.out.println("<<<<< Enter 'E' to Exit     >>>>>\n");
		
		System.out.print("Your option: ");
		return scan.nextLine();
	}
	
	/*team selection function*/
	private static void selectTeams() { 
		System.out.print("\nEnter team 01 name:");
		String team01_name = scan.nextLine();
		
		System.out.print("Enter team 02 name:");
		String team02_name = scan.nextLine();
		
		if(team01_name.equalsIgnoreCase(team02_name)) { // validate team names
			System.out.print("\nTeam names cannot be same..Please try again!");
			selectTeams();
		}
		else {
			cricketGame.getTeam01().setTeamName(team01_name); // set team 01 name
			cricketGame.getTeam02().setTeamName(team02_name); // set team 02 name
		}
	}// end team selection function
	
	/*Start main function*/
	public static void main(String[] args) throws InterruptedException { // 
		
		cricketGame = new Game(); // initializing a new game
		
		String main_menu_option = showMainMenu();// showing main menu
		
		if(main_menu_option.equalsIgnoreCase("P")) { // validate user input
			
			while(main_menu_option.equalsIgnoreCase("P")) {
				selectTeams(); // calling game functions step by step
				
				tossingCoin();
						
				play();
				
				showScoreBoard();
				
				cricketGame = new Game(); // initializing a new game
				
				main_menu_option = showMainMenu(); // showing main menu again to user after finishing a game
			}
		}
		else if(main_menu_option.equalsIgnoreCase("E")) {
			return; // exiting from the application
		}
		else {
			System.out.println("\nInvalid Input..Try again!!!");
			main(args); // recursive main function when invalid user input
		}
	}
}
