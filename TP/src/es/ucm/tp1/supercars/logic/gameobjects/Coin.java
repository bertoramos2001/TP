package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	
	private static int numCoins;
	private boolean alive = true;
	
	public Coin (Game game, int x, int lane) {
		super(game, x, lane);
	}

	public static void reset() {
		numCoins = 0;
		
	}

	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.addCoin();
		this.alive = false;
		
		return true;
	}

	@Override
	public void onEnter() {
		numCoins++;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		numCoins--;
		
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
}
