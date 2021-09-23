package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private Player player;
	private Obstacle obstacle;
	private Coin coin;
	

	public Game(long seed, Level level) {
		// TODO 	
		player = new Player();
		obstacle = new Obstacle();
		coin = new Coin();
	}
	
	public void update() {
		//TODO
	}
	
	public void toggleTest() {
		// TODO 
	}
	
	public int getVisibility() {
		//TODO: hacer función
		return 8;
	}
	
	public int getRoadWidth() {
		//TODO: hacer función
		return 3;
	}

	public String positionToString(int j, int i) {
		return "";
	}
}
