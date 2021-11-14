package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject {
	public static final String INFO = "[TRUCK] moves towards the player\n";
	private final String TRUCK_SYMBOL = "←";

	public Truck(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO ver si recibe disparo
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO ver si recibe explosion
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
		x -= 1;
	}

	@Override
	public void onDelete() {
	}
	
	@Override
	protected String getSymbol() {
		return TRUCK_SYMBOL;
	}

}
