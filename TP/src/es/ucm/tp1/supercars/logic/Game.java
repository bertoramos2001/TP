package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Game {
	
	private Player player;
	private GameObjectContainer gameObjectContainer;

	public int getVisibility() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRoadLength() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getRoadWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRandomLane() {
		// TODO Auto-generated method stub
		return 0;
	}

	//TODO ESTO ESTÁ MAL, DEBERIA HABER UN SOLO TRY TO ADD OBJECT INDIFERENTEMENTE DEL TIPO DE OBJETO
	public void tryToAddObject(Obstacle obstacle, double obstacleFrequency) {
		// TODO Auto-generated method stub
		
	}

	public void tryToAddObject(Coin coin, double coinFrequency) {
		// TODO Auto-generated method stub
		
	}
	
	public void tryToAddObject (GameObject o, double frequency) {
		
	}

	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public GameObject getObjectInPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public String positionToString(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayerPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean testMode() {
		// TODO Auto-generated method stub
		return false;
	}

	public double getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getTotalObstacles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getActualCoins() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDistanceToEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTotalCoins() {
		// TODO Auto-generated method stub
		return null;
	}


}
