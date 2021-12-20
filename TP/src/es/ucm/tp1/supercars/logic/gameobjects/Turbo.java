package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject {

	public static final String INFO = "[TURBO] pushes the car: 3 columns\n";
	private final String TURBO_SYMBOL = ">>>";
	private boolean alive = true;

	public Turbo(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.jump();
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
	}

	@Override
	protected String getSymbol() {
		return TURBO_SYMBOL;
	}

	@Override
	public boolean receiveExplosion() {
		alive = false;
		return true;
	}

	@Override
	public boolean receiveWave() {
		x += 1;
		return false;
	}

	@Override
	public boolean receiveThunder() {
		return false;
	}
}