package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coins {
	
	public static final String INFO = "[SUPERCOIN] gives 1000 coins\n";
	private final String SUPERCOIN_SYMBOL = "$";
	private final int COINS_AWARDED = 1000;
	private static boolean superCoinPresent = false;

	public SuperCoin(Game game, int x, int lane) {
		super(game, x, lane);
		coinsAwarded = COINS_AWARDED;
		symbol = SUPERCOIN_SYMBOL;
	}

	@Override
	public void onEnter() {
		superCoinPresent = true;
	}

	@Override
	public void onDelete() {
		superCoinPresent = true;
	}
	
	public static boolean hasSuperCoin() {
		return superCoinPresent;
	}

}
