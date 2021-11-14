package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject {
	
	private static int numCoins;
	public static final String INFO = "[Coin] gives 1 coin to the player\n";
	private final String COIN_SYMBOL = "¢";
	private final int COINS_AWARDED = 1;
	private boolean alive = true;
	
	public Coin (Game game, int x, int lane) {
		super(game, x, lane);
	}
	
	//MÉTODOS QUE GESTIONAN LAS COLISIONES
	@Override
	public boolean receiveCollision(Player player) {
		player.addCoin(COINS_AWARDED);
		alive = false;
		
		return true;
	}
	
	@Override
	public boolean receiveShoot() {
		return false;
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
	//MÉTODOS QUE GESTIONAN EL MOVIMIENTO DEL JUGADOR (en este caso nada)
	@Override
	public void update() {
	}
	//MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL COIN
	@Override
	public boolean isAlive() {
		return alive;
	}

	public static int getTotalCoins() {
		return numCoins;
	}
	@Override
	protected String getSymbol() {
		return COIN_SYMBOL;
	}
	//MÉTODOS QUE MODIFICAN INFORMACIÓN DEL COIN
	public static void reset() {
		numCoins = 0;
		
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}
}
