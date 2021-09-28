package es.ucm.tp1.logic;

public class Player {
	private int x, y, numCoins; //TODO: faltan atributos
	private Game game;
	
	public Player(Game game) {
		this.game = game;
		x = 1;
		y = 1;
	}
	
	public void moveForward() {
		y += 1;
	}
	
	public void moveUpwards() {
		
	}
	
	public void moveDownwards() {
		
	}
	
	public boolean playerIsInPosition(int i, int j) {
		return x == i && y == j;
	}
}
