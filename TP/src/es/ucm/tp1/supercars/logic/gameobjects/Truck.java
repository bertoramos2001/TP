package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends Obstacles {
	public static final String INFO = "[TRUCK] moves towards the player\n";
	private final String TRUCK_SYMBOL = "←";
	private final int LIVES = 0;

	public Truck(Game game, int x, int lane) {
		super(game, x, lane);
		symbol = TRUCK_SYMBOL;
		lives = LIVES;
	}

	@Override
	public void update() {
		x -= 1;
	}
}