package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coins extends GameObject {
	
	private boolean alive = true;
	protected int coinsAwarded;
	protected String symbol;

	public Coins(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.addCoin(coinsAwarded);
		alive = false;
		
		return true;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public boolean receiveWave() {
		x += 1;
		return true;
	}

	@Override
	public boolean isAlive() {
		return alive;
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
	
	@Override
	protected String getSymbol() {
		return symbol;
	}

	@Override
	public boolean receiveThunder() {
		return false;
	}

}