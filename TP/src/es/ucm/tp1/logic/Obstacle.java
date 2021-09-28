package es.ucm.tp1.logic;

public class Obstacle {
	private int x, y;
	private Game game; 
	public final static String INFO = "[Obstacle] hits car";
	
	public Obstacle(Game game) {
		this.game = game;
	}
}
