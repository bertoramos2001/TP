package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	private static int numObstacles;
	
	public Obstacle (Game game, int x, int lane) {
		super(game, x, lane);
	}

	public static void reset() {
		numObstacles = 0;
		
	}

	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}

	@Override
	public void onEnter() {
		numObstacles++;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}
}
