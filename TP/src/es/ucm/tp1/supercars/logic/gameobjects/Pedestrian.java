package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject {
	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down\n";
	private final String PEDESTRIAN_SYMBOL = "☺";

	public Pedestrian(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		player.removeCoins();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO no se si recibe tiro
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO no se si recibe explosion
		return false;
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
		y = (y+1) % 3;
	}

	@Override
	public void onDelete() {
	}
	
	@Override
	protected String getSymbol() {
		return PEDESTRIAN_SYMBOL;
	}

}
