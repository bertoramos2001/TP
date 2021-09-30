package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {

	private Player player;
	private Obstacle obstacle; // aqui iran definidos las listas de monedas y obstaculos, que contendrán los
								// objetos de monedas y obstáculos
	private Coin coin;
	private Level level;

	public Game(long seed, Level level) {
		// TODO
		player = new Player(this);
		this.level = level;
		int roadLength = level.length;

		
//		 for (int x = getVisibility() / 2; x < roadLength; x++) {
//		 tryToAddObstacle(this, x, level.getRandomLane(), level.obstacleFrequency());
//		 tryToAddCoin(this, x, level.getRandomLane(), level.coinFrequency()); }
		 
	}

	// private void tryToAddObstacle(Game game, int x, int randomLane, double
	// obstacleFrequency) {}

	// private void tryToAddCoin(Game game, int x, int randomLane, double
	// coinFrequency) {}

	// public boolean Random.nextDouble(){}

	public void update() {
		// TODO
	}

	public void toggleTest() {
		// TODO
		level = Level.TEST;
	}

	public int getVisibility() {
		// TODO: hacer función
		return 8;
	}

	public int getRoadWidth() {
		// TODO: hacer función
		return 3;
	}

	public void moveForward() {
		player.moveForward();
	}

	public void moveUp() {
		player.moveUp();
	}

	public void moveDown() {
		player.moveDown();
	}

	public String positionToString(int j, int i) {
		if (player.playerIsInPosition(i, j))
			return ">";
		else
			return "";
	}

	public void getObjectsInfo() {
		System.out.println(player.INFO);
		System.out.println(coin.INFO);
		System.out.println(obstacle.INFO);
	}

	public int getPosition() {
		return player.getPosition();
	}
}
