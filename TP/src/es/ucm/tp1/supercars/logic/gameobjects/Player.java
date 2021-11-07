package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	
	private Game game;
	private int x, y, actualCoins;
	private final int INITIAL_COINS = 5;
	private boolean alive = true;
	public static final String INFO = "[Car] the racing car\n";
	private final String ALIVE_PLAYER_SYMBOL = ">";
	private final String DEAD_PLAYER_SYMBOL = "@";
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
		
		this.game = game;
		initialize(x, y);
	}
	
	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;
		actualCoins = INITIAL_COINS;
	}

	//MÉTODOS QUE GESTIONAN LAS COLISIONES
	@Override
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		
		if (other != null) {
			return other.receiveCollision(this);
		}
		
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}
	//MÉTODOS QUE GESTIONAN LOS EVENTOS
	@Override
	public void onEnter() {
	}
	
	@Override
	public void onDelete() {
	}
	
	//MÉTODOS QUE GESTIONAN EL MOVIMIENTO DEL JUGADOR
	public void moveDown() {
		if (y < game.getRoadWidth() - 1)
			y += 1;
		
		update();
	}
	
	public void moveUp() {
		if (y > 0)
			y -= 1;
		
		update();
	}

	@Override
	public void update() {
		x += 1;
		setPosition(x, y);
		doCollision();
	}
	
	//MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL PLAYER
	public int getPositionX() {
		return this.x;
	}
	
	public int getActualCoins() {
		return actualCoins;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}
	@Override
	public String toString() {
		return getSymbol();
	}
	
	@Override
	protected String getSymbol() {
		if (alive) {
			return ALIVE_PLAYER_SYMBOL;
		}
		return DEAD_PLAYER_SYMBOL;
	}
	
	//MÉTODOS QUE MODIFICAN INFORMACIÓN DEL PLAYER
	public void addCoin() {
		actualCoins += 1;
	}
	
	public void setDead() {
		alive = false;
	}
}
