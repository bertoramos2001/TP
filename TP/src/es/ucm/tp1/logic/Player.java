package es.ucm.tp1.logic;

public class Player {
	private int x, y, actualCoins;
	private Game game;
	public final static String INFO = "[Car] the racing car";
	private final String ALIVE_PLAYER_SYMBOL = ">";
	private final String DEAD_PLAYER_SYMBOL = "@";
	private boolean alive;

	public Player(Game game) {
		this.game = game;
		x = 0;
		y = game.getRoadWidth() / 2;
		actualCoins = 5;
		alive = true;
	}
	
	private void doCollisions() {
		Coin coin = game.getCoinInPosition(x, y);
		if (coin != null) {
			addCoin();
			game.removeCoin(coin);
		}
		
		Obstacle obs = game.getObstacleInPosition(x, y);
		if (obs != null) {
			alive = false;
		}
	}

	public void moveForward() {
		x += 1;
		doCollisions();
	}

	public void moveUp() {
		if (y > 0)
			y -= 1;
		x += 1;
		doCollisions();
	}

	public void moveDown() {
		if (y < game.getRoadWidth() - 1)
			y += 1;
		x += 1;
		doCollisions();
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
		if (alive)
			return ALIVE_PLAYER_SYMBOL;
		return DEAD_PLAYER_SYMBOL;
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
	
	public void addCoin(){
		actualCoins += 1;
	}
	
	public void deletePlayerCoins() {
		actualCoins = 0;
	}
	
	public boolean getAlive() {
		return alive;
	}
}
