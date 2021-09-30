package es.ucm.tp1.logic;

public class Player {
	private int x, y, numCoins; // TODO: faltan atributos
	private Game game;
	public final static String INFO = "[Car] the racing car";

	public Player(Game game) {
		this.game = game;
		x = 1;
		y = 1;
	}

	public void moveForward() {
		x += 1;
	}

	public void moveUp() {
		if (x > 0)
			x -= 1;
		y += 1;
	}

	public void moveDown() {
		if (x < 2)
			x += 1;
		y += 1;
	}

	public boolean playerIsInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getPosition() {
		return this.y;
	}
}
