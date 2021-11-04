package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	private static int numObstacles;
	public static final String INFO = "[Obstacle] hits car\n";
	
	public Obstacle (Game game, int x, int lane) {
		super(game, x, lane);
	}
	
	//MÉTODOS QUE GESTIONAN LAS COLISIONES
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}
	//MÉTODOS QUE GESTIONAN LOS EVENTOS
	@Override
	public void onEnter() {
		numObstacles++;
	}
	
	@Override
	public void onDelete() {
	}
	//MÉTODOS QUE GESTIONAN EL MOVIMIENTO DEL JUGADOR (en este caso nada)
	@Override
	public void update() {
	}
	//MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL COIN
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}

	public static int getTotalObstacles() {
		return numObstacles;
	}
	//MÉTODOS QUE MODIFICAN INFORMACIÓN DEL COIN
	public static void reset() {
		numObstacles = 0;
	}
}
