package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends Coins {
	
	private static int numCoins;
	public static final String INFO = "[Coin] gives 1 coin to the player\n";
	private final String COIN_SYMBOL = "¢";
	private final int COINS_AWARDED = 1;
	
	public Coin (Game game, int x, int lane) {
		super(game, x, lane);
		coinsAwarded = COINS_AWARDED;
		symbol = COIN_SYMBOL;
	}
	
	//MÉTODOS QUE GESTIONAN LOS EVENTOS
	@Override
	public void onEnter() {
		numCoins++;
	}
	
	@Override
	public void onDelete() {
		numCoins--;
	}
	//MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL COIN
	public static int getTotalCoins() {
		return numCoins;
	}
	
	//MÉTODOS QUE MODIFICAN INFORMACIÓN DEL COIN
	public static void reset() {
		numCoins = 0;
		
	}
}
