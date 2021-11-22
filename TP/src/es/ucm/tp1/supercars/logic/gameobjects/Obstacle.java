package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends Obstacles {
	
	public static final String INFO = "[Obstacle] hits car\n";
	private final String OBSTACLE_SYMBOL = "░";
	private final int LIVES = 0;
	
	public Obstacle (Game game, int x, int lane) {
		super(game, x, lane);
		lives = LIVES;
		symbol = OBSTACLE_SYMBOL;
	}
}
