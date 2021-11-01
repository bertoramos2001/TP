package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	
	private Game game;
	private int x, y, actualCoins;
	private final int INITIAL_COINS = 5;
	private boolean alive = true;
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
		
		this.game = game;
		this.x = x;
		this.y = y;
		actualCoins = INITIAL_COINS;
	}

	@Override
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		
		if (other != null) {
			return other.receiveCollision(this);
		}
		
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
		x += 1;
		doCollision();
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	public int getPositionX() {
		return this.x;
	}
	
	public int getActualCoins() {
		return actualCoins;
	}
	
	public void addCoin() {
		actualCoins += 1;
	}
	
	public void setDead() {
		alive = false;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
}
