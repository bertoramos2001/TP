package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

/* (comentarios para el examen)
 * PASOS PARA AÑADIR GAME OBJECTS:
 * 		1. crear la clase dentro de gameobjects y que extienda gameobject
 * 		2. hacer override de las funciones que fuera necesario y crear tambien nuevas si hacen falta
 * 		3. añadirlo en el help e info
 * 		4. depende de lo que me digan en el enunciado, meterlo en el juego de una u otra manera (forzado como los avanzados, aleatorio como los normales...)
 * 
 */

public abstract class GameObject implements Collider {

	protected int x, y;
	protected Game game;
	protected String symbol;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String serialize() {
		return (getSymbol() + " (" + x + ", " + y + ")");
	}

	public abstract boolean isAlive();

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();

}