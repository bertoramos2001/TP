package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject {
	
	public static final String INFO = "[SUPERCOIN] gives 1000 coins\n";
	private final String SUPERCOIN_SYMBOL = "$";
	private final int COINS_AWARDED = 1000;

	public SuperCoin(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.addCoin(COINS_AWARDED);
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO falta implementar
		return false;
	}

	@Override
	public void onEnter() {
		// TODO falta implementar
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		// TODO falta implementar
	}
	
	@Override
	protected String getSymbol() {
		return SUPERCOIN_SYMBOL;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

}
