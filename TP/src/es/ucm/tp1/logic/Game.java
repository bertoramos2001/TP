package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private Player player;
	private Obstacle obstacle;
	private Coin coin;
	private Level level;
	

	public Game(long seed, Level level) {
		// TODO 	
		player = new Player();
		this.level = level;
	}
	
	public void update() {
		//TODO
	}
	
	public void toggleTest() {
		// TODO 
		level = Level.TEST;
	}
	
	public int getVisibility() { 
		//TODO: hacer función
		return 8;
	}
	
	public int getRoadWidth() {
		//TODO: hacer función
		return 3;
	}
	
	public void moveForward() {
		player.moveForward();
	}

	public String positionToString(int j, int i) {
		if (player.playerIsInPosition(i, j)) 
		 return ">";
		else
			return "";
	}
}
