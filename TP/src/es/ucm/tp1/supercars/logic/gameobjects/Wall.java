package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacles {
	
	public static final String INFO = "[WALL] hard obstacle\n";
	private final String WALL_SYMBOL_ARR[] = {"░", "▒", "█"};
	private final int  NUM_COINS_GIVEN = 5;
	private final int LIVES = 2;

	public Wall(Game game, int x, int lane) {
		super(game, x, lane);
		symbol = WALL_SYMBOL_ARR[lives];
		lives = LIVES;
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;
		if (!isAlive()) {
			game.addPlayerCoins(NUM_COINS_GIVEN);
		}
		return true;
	}
	//TODO: ver si el receive explosion funciona bien dejandolo en Obstacles y aqui no
	

}
