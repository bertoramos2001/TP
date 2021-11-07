package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	private ArrayList<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<GameObject>();
	}

	public GameObject getObjectInPosition(int x, int y) {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i).getX() == x && gameObjects.get(i).getY() == y) {
				return gameObjects.get(i);
			}
		}
		return null;
	}

	public void add(GameObject o) {
		gameObjects.add(o);
		o.onEnter();
	}
	
	public void deleteDead() {
		ArrayList<GameObject> aux = new ArrayList<GameObject>();
		
		for (GameObject o : gameObjects) {
			if (o.isAlive()) {
				aux.add(o);
			} else {
				o.onDelete();
			}
		}
		gameObjects = aux;
	}
}
