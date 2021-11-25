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
	//TODO: esta bien?
	private double currentTime;
	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		player = new Player(this, 0, getRoadWidth() / 2);
		initialize();
	}
	
	public void initialize() {
		rand = new Random(seed);
		initialTime = 0;
		gameFinished = false;
		modoTest = false;
		cycleNum = 0;
		GameObjectGenerator.reset();
		player.initialize(0, level.getRoadWidth() / 2);
		gameObjectContainer = new GameObjectContainer();
		startTimer();
		
		GameObjectGenerator.generateGameObjects(this, level);
	}
	
	public void initialize(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		initialize();
	}

	//MÉTODOS PARA OBTENER INFORMACIÓN DEL NIVEL
	public int getPlayerPositionX() {
		return player.getX();
	}
	
	public int getPlayerPositionY() {
		return player.getY();
	}

	public int getVisibility() {
		return level.getRoadVisibility();
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
	
	public int getRandomVisibleColumn() {
		return (int) (getRandomNumber() * getVisibility());
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
	
	public void forceAddObject(GameObject o) {
		gameObjectContainer.deleteColumn(o.getX());
		gameObjectContainer.add(o);
	}
	
	//MÉTODOS PARA OBTENER INFORMACIÓN Y MANEJAR OBJETOS
	public String positionToString(int x, int y) {
		String s = "";
		
		if (player.isInPosition(x, y)) {
			s += (player.toString());
			s += " ";
		}
		
		s += gameObjectContainer.printObjectsIn(x, y);
		
		if (getRoadLength() == x) {
			s += (FINISH_LINE);
			s += " ";
		}
		
		return s;
	}
	
	public int getActualCoins() {
		return player.getActualCoins();
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		return gameObjectContainer.getObjectInPosition(x, y);
	}
	
	public void movePlayerForward() {
		player.moveForward();
	}
	
	public void update() {
		gameObjectContainer.update();
		GameObjectGenerator.generateRuntimeObjects(this);
		addCycle();
		currentTime = ((double)System.currentTimeMillis() - getInitialTime()) / 1000;
		deleteDeadObjects();
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
		return getPlayerPositionX() == getRoadLength() + 1;
	}
	
	public void deleteDeadObjects() {
		gameObjectContainer.deleteDead();
	}
	
	public void clearGameObjects() {
		gameObjectContainer.deleteAll();
	}
	
	public void addPlayerCoins(int c) {
		player.addCoin(c);
	}
	
	public void removePlayerCoins() {
		player.removeCoins();
	}
	
	public void extractPlayerCoins(int c) {
		player.extractCoins(c);
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
	
	public double getCurrentTime() {
		return currentTime;
	}
	
	public void toggleTest() {
		modoTest = true;
	}

	public void gameOver() {
		gameFinished = true;
	}
	
	public void forceAdvancedObjects(int id) {
		GameObjectGenerator.forceAdvanceObject(this, id, getPlayerPositionX() + getVisibility() - 1);
	}
	
	public void execute(InstantAction instAct) {
		instAct.execute(this);
	}
	
	public Level getLevel() {
		return level;
	}
}
