package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject{
	
	public static final String INFO = "[WALL] hard obstacle\n";
	private final String WALL_SYMBOL_ARR[] = {"░", "▒", "█"};
	private static final int  NUM_COINS_GIVEN = 5;
	private int lives = 2;

	public Wall(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;//TODO: esto deben implementarlo todos los obstaculos, por lo que deberia ir en un objeto padre
		game.addPlayerCoins(NUM_COINS_GIVEN);
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		//TODO: probablemente esto haya que quitarlo
		receiveShoot();
		return false;
	}

	@Override
	public boolean isAlive() {
		return lives > 0;
	}

	@Override
	public void onEnter() {
		//TODO: debe aumentar el numero de obstaculos pero tenemos que tener una clase padre
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		///TODO: debe disminuir el numero de obstaculos pero tenemos que tener una clase padre
	}
	
	@Override
	protected String getSymbol() {
		return WALL_SYMBOL_ARR[lives];
	}
	
	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		return false;
	}

}
