package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	public Obstacle (Game game, int x, int lane) {
		super(game, x, lane);
	}

	public static void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}
