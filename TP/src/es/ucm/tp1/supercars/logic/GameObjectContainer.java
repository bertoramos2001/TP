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
	
	public void deleteAll() {
		for (GameObject o : gameObjects) {
			o.onDelete();
		}
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void deleteColumn(int column) {
		ArrayList<GameObject> aux = new ArrayList<GameObject>();
		
		for (GameObject o : gameObjects) {
			if (o.getX() == column) {
				o.onDelete();
			} else {
				aux.add(o);
			}
		}
		gameObjects = aux;
	}
	
	public void update() {
		for (GameObject o : gameObjects) {
			o.update();
		}
		
	}
	
	public String printObjectsIn(int x, int y) {
		String s = "";
		for (GameObject o : gameObjects) {
			if (o.getX() == x && o.getY() == y) {
				s += o.toString() + " ";
			}
		}
		//TODO: poner s.trim() y ver si pasa los tests de la granada
		return s;
	}
	
	public String serialize(int levelLength, int levelWidth) {
		String s = "";
		
		for (int i = 0; i < levelLength; i++) {
			for (int j = 0; j < levelWidth; j++) {
				GameObject obj = getObjectInPosition(i, j);
				if (obj != null) {
					s += obj.serialize() + "\n";
				}
			}
		}
		return s;
	}
	
	
}