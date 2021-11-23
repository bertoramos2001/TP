package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacles extends GameObject {
	
	protected int lives;
	protected String symbol;
	protected static int numObstacles;

	public Obstacles(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		lives = -1;
		return true;
	}

	@Override
	public boolean receiveWave() {
		x += 1;
		return true;
	}

	@Override
	public boolean isAlive() {
		return lives > -1;
	}

	@Override
	public void onEnter() {
		numObstacles++;
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		numObstacles--;
	}
	
	public static int getTotalObstacles() {
		return numObstacles;
	}
	
	public static void reset() {
		numObstacles = 0;
	}
	
	@Override
	protected String getSymbol() {
		return symbol;
	}

}
