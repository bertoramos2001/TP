package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Controller;
import es.ucm.tp1.control.Level;

public class Game {

	private Player player;
	private Level level;
	private CoinList coinList;
	private ObstacleList obstacleList;
	private Random rand;
	private double startTime;
	private boolean modoTest;
	private final String FINISH_LINE = "¦";
	private final String MOVE_FORWARD_COM = "n";
	private final String MOVE_UP_COM = "q";
	private final String MOVE_DOWN_COM = "a";
	private int cicleNum;

	public Game(long seed, Level level) {
		
		this.level = level;
		player = new Player(this);
		obstacleList = new ObstacleList(level.getRoadLength());
		coinList = new CoinList(level.getRoadLength());
		rand = new Random(seed);
		startTime = 0;
		modoTest = false;
		cicleNum = 0;
		
		AddObjects();
				 
	}
	
	private void AddObjects() {
		int roadLength = level.getRoadLength();
		for (int x = getVisibility() / 2; x < roadLength; x++) {
			tryToAddObstacle(this, x, getRandomLane(), level.obstacleFrequency());
			tryToAddCoin(this, x, getRandomLane(), level.coinFrequency()); 
		}
	}

	private void tryToAddObstacle(Game game, int x, int randomLane, double obstacleFrequency) {
		if (rand.nextDouble() < obstacleFrequency) {
			Obstacle obs = new Obstacle(game, x, randomLane);
			obstacleList.add(obs);
		}
	}
	
	private void tryToAddCoin(Game game, int x, int randomLane, double coinFrequency) {
		//si el double random es menor que la frecuencia y no hay ningún obstáculo, añadiremos la moneda
		if ((rand.nextDouble() < coinFrequency) && (obstacleList.getObstacleInPosition(x, randomLane) == null)) {
			Coin coin = new Coin(game, x, randomLane);
			coinList.add(coin);
		}
	}
	//Métodos para gestionar modo test
	public void testModeON(){
		this.modoTest = true;
	}
	
	public boolean testMode(){
		return this.modoTest;
	}
	
	public void toggleTest() {
		testModeON();
		coinList.deleteCoinList();
	}
	//Métodos para random y tiempo actual
	public void startTimer(){
		this.startTime = System.currentTimeMillis();
	}
	
	public double getTime(){
		return this.startTime;
	}

	public int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	
	public Double getRandomNumber() {
		return rand.nextDouble(); 
	}

	public void restart() {
		player.resetPosition();
		//player.deletePlayerCoins();
	}
	//Métodos para obtener parámetros del nivel
	public int getVisibility() {
		return level.getRoadVisibility() + player.getPositionX();
	}

	public int getRoadWidth() {
		return level.getRoadWidth();
	}
	
	public int getRoadLength() {
		return level.getRoadLength();
	}
	
	public int getDistanceToEnd() {
		return getRoadLength() - getPosition();
	}
	
	public int getCycle() {
		return cicleNum;
	}
	
	public void addCycle() {
		cicleNum += 1;
	}
	//Métodos para mover jugador
	public void update(String com) {
		if (com == MOVE_FORWARD_COM) {
			moveForward();
		} else if (com == MOVE_UP_COM) {
			moveUp();
		} else if (com == MOVE_DOWN_COM) {
			moveDown();
		}
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
	//Métodos para obtener información de objetos
	public String positionToString(int x, int y) {
		if (player.playerIsInPosition(x, y))
			return player.toString();
		
		Coin coin = coinList.getCoinInPosition(x, y);
		if (coin != null)
			return coin.toString();
		
		Obstacle obstacle = obstacleList.getObstacleInPosition(x, y);
		if (obstacle != null)
			return obstacle.toString();
		
		if (x == getRoadLength()) 
			return FINISH_LINE;
		
		return "";
		
	}
	
	public void getObjectsInfo() {
		System.out.println(Player.INFO);
		System.out.println(Coin.INFO);
		System.out.println(Obstacle.INFO);
	}
	
	public int getPosition() {
		return player.getPositionX();
	}

	public int getActualCoins() {
		return player.getActualCoins();
	}
	
	public int getTotalCoins() {
		return coinList.getTotalCoins();
	}
	
	public int getTotalObstacles() {
		return obstacleList.getTotalObstacles();
	}
	
	public Coin getCoinInPosition(int x, int y) {
		return coinList.getCoinInPosition(x, y);
	}
	
	public Obstacle getObstacleInPosition(int x, int y) {
		return obstacleList.getObstacleInPosition(x, y);
	}
	
	public boolean getPlayerAlive() {
		return player.getAlive();
	}
	
	public void removeCoin(Coin coin) {
		coinList.remove(coin);
	}
}
