package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;
	protected Game game;
	protected String symbol;

	public GameObject(Game game, int x, int y) {
		setPosition(x, y);
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}
	
	protected void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract boolean isAlive();

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();

}
