package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	private static int numObstacles;
	public static final String INFO = "[Obstacle] hits car\n";
	private final String OBSTACLE_SYMBOL = "░";
	private boolean alive = true;
	
	public Obstacle (Game game, int x, int lane) {
		super(game, x, lane);
	}
	
	//MÉTODOS QUE GESTIONAN LAS COLISIONES
	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}
	
	@Override
	public boolean receiveShoot() {
		alive = false;
		return false;
	}
	//MÉTODOS QUE GESTIONAN LOS EVENTOS
	@Override
	public void onEnter() {
		numObstacles++;
	}
	
	@Override
	public void onDelete() {
		numObstacles--;
	}
	//MÉTODOS QUE GESTIONAN EL MOVIMIENTO DEL JUGADOR (en este caso nada)
	@Override
	public void update() {
	}
	//MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL OBSTACLE
	@Override
	public boolean isAlive() {
		return alive;
	}

	public static int getTotalObstacles() {
		return numObstacles;
	}
	
	@Override
	protected String getSymbol() {
		return OBSTACLE_SYMBOL;
	}
	//MÉTODOS QUE MODIFICAN INFORMACIÓN DEL OBSTACLE
	public static void reset() {
		numObstacles = 0;
	}

	@Override
	public boolean receiveExplosion() {
		receiveShoot();
		return false;
	}
}
