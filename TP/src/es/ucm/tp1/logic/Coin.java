package es.ucm.tp1.logic;

public class Coin {
	private int x, y;
	private Game game; 
	public final static String INFO = "[Coin] gives 1 coin to the player";
	
	public Coin(Game game) {
		this.game = game;
	}
}
