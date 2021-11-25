package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacles {
	
	public static final String INFO = "[WALL] hard obstacle\n";
	private final String WALL_SYMBOL_ARR[] = {"░", "▒", "█"};
	private final int  NUM_COINS_GIVEN = 5;
	private final int LIVES = 2;

	public Wall(Game game, int x, int lane) {
		super(game, x, lane);
		lives = LIVES;
		symbol = WALL_SYMBOL_ARR[lives];
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;
		if (isAlive()) {
			symbol = WALL_SYMBOL_ARR[lives];
		}
		return true;
	}
	
	@Override
	public boolean receiveExplosion() {
		lives = -1;
		return true;
	}
	
	@Override
	public void onDelete() {
		game.addPlayerCoins(NUM_COINS_GIVEN);
	}
}
