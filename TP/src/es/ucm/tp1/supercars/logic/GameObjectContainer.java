package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	private ArrayList<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<GameObject>();
	}

	public GameObject getObjectInPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(GameObject o) {
		gameObjects.add(o);
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
