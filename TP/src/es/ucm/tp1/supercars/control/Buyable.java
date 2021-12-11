package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;

public interface Buyable {
	public int cost();
	static final String NOT_ENOUGTH_COINS = "Not enough coins";
	
	public default void buy(Game game) throws NotEnoughCoinsException{
		int cost = cost();
		
		if (cost <= game.getActualCoins()) {
			game.extractPlayerCoins(cost);
		} else { 
			throw new NotEnoughCoinsException(NOT_ENOUGTH_COINS);
		}
		
	}
}