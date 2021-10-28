package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Player {
	
	private int x, y;
	private Game game;
	
	public Player (Game game) {
		this.game = game;
		x = 0;
		y = 0;
	}
	
	
	
	public boolean doCollision() {
		
		Collider other = game.getObjectInPosition(x, y);
		
		if (other != null) {
			return other.receiveCollision (this);
		}
		
		return false;
	}
}
