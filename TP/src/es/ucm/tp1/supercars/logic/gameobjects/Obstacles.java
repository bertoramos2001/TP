package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacles extends GameObject {
	
	protected int lives;
	protected String symbol;

	public Obstacles(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		lives -= 1;
		return false;
	}

	@Override
	public boolean receiveWave() {
		// TODO falta implementar
		return false;
	}

	@Override
	public boolean isAlive() {
		return lives > -1;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
	}

}
