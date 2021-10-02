package es.ucm.tp1.logic;

public class Coin {
	private int x, y;
	private Game game;
	public final static String INFO = "[Coin] gives 1 coin to the player";
	private final String COIN_SYMBOL = "¢";

	public Coin(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) 
			return true;
		
		if (obj == null) 
			return false;
		
		if (obj.getClass() != this.getClass())
			return false;
		
		Coin coin = (Coin) obj;
		return ((x == coin.x) && (y == coin.y));
	}
	
	@Override
	public String toString() {
		return COIN_SYMBOL;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
