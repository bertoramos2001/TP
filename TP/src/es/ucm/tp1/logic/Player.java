package es.ucm.tp1.logic;

public class Player {
	private int x, y, actualCoins;
	private Game game;
	public final static String INFO = "[Car] the racing car";
	private final String PLAYER_SYMBOL = ">";

	public Player(Game game) {
		this.game = game;
		x = 0;
		y = 1;
		actualCoins = 0;
	}

	public void moveForward() {
		x += 1;
	}

	public void moveUp() {
		if (y > 0)
			y -= 1;
		x += 1;
	}

	public void moveDown() {
		if (y < 2)
			y += 1;
		x += 1;
	}

	public void resetPosition() {
		x = 0;
		y = 1;
	}
	
	public boolean playerIsInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	@Override
	public String toString() {
		return PLAYER_SYMBOL;
	}

	public int getPositionX() {
		return this.x;
	}
	
	public int getPositionY() {
		return this.y;
	}
	
	public int getActualCoins() {
		return actualCoins;
	}
	
	public int addCoin(){
		actualCoins += 1;
		return actualCoins;	
	}
	
	public void deletePlayerCoins() {
		actualCoins = 0;
	}
}
