package es.ucm.tp1.supercars.logic;

import java.util.Random;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.control.Level;

public class Game {
	
	private Player player;
	private GameObjectContainer gameObjectContainer;
	private Random rand;
	private Level level;
	private long seed;
	private double initialTime;
	private boolean modoTest, gameFinished;
	private int cycleNum;
	private final String FINISH_LINE = "¦";
	
	public Game(long seed, Level level) {
		setGameParams(seed, level);
		player = new Player(this, 0, getRoadWidth() / 2);
		initialize();
	}
	
	public void initialize() {
		rand = new Random(seed);
		initialTime = 0;
		modoTest = false;
		gameFinished = false;
		cycleNum = 0;
		player.initialize(0, level.getRoadWidth() / 2);
		gameObjectContainer = new GameObjectContainer();
		
		GameObjectGenerator.generateGameObjects(this, level);
	}
	
	public void setGameParams(long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}

	//MÉTODOS PARA OBTENER INFORMACIÓN DEL NIVEL
	public int getPlayerPositionX() {
		return player.getPositionX();
	}

	public int getVisibility() {
		return level.getRoadVisibility() + getPlayerPositionX();
	}

	public int getRoadLength() {
		return level.getRoadLength();
	}
	
	public int getRoadWidth() {
		return level.getRoadWidth();
	}
	
	public int getDistanceToEnd() {
		return getRoadLength() - getPlayerPositionX();
	}
	
	public int getCycle() {
		return cycleNum;
	}
	
	public void addCycle() {
		cycleNum += 1;
	}
	
	//MÉTODOS DE RANDOM Y TIEMPO ACTUAL
	public int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	
	private double getRandomNumber() {
		return rand.nextDouble(); 
	}
	
	public void startTimer(){
		this.initialTime = System.currentTimeMillis();
	}
	
	public void tryToAddObject (GameObject o, double frequency) {
		if ((getRandomNumber() < frequency) && (getObjectInPosition(o.getX(), o.getY()) == null)) {
			gameObjectContainer.add(o);
		}
	}
	
	//MÉTODOS PARA OBTENER INFORMACIÓN Y MANEJAR OBJETOS
	public String positionToString(int x, int y) {
		GameObject obj = getObjectInPosition(x, y);
		
		if (player.isInPosition(x, y)) {
			return player.toString();
		} else if (obj != null) {
			return obj.toString();
		} else if (getRoadLength() == x) {
			return FINISH_LINE;
		}
		
		return "";
	}
	
	public int getActualCoins() {
		return player.getActualCoins();
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		return gameObjectContainer.getObjectInPosition(x, y);
	}
	
	public void update() {
		player.update();
		addCycle();
	}
	
	public void movePlayerDown() {
		player.moveDown();
		
	}
	
	public void movePlayerUp() {
		player.moveUp();
		
	}
	
	public boolean getPlayerIsAlive() {
		return player.isAlive();
	}
	
	public boolean playerWon() {
		return player.getX() == getRoadLength() + 1;
	}
	
	public void deleteDeadObjects() {
		gameObjectContainer.deleteDead();
	}

	
	//MÉTODOS QUE MANEJAN INFORMACIÓN DEL JUEGO
	public boolean isFinished() {
		return gameFinished;
	}
	
	public boolean testMode() {
		return modoTest;
	}
	
	public double getInitialTime() {
		return initialTime;
	}
	
	public void toggleTest() {
		modoTest = !modoTest;
	}

	public void gameOver() {
		gameFinished = true;
	}
}
