package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {

	private Game game;
	private int actualCoins;
	private final int INITIAL_COINS = 5;
	private boolean alive = true;
	public static final String INFO = "[Car] the racing car\n";
	private final String ALIVE_PLAYER_SYMBOL = ">";
	private final String DEAD_PLAYER_SYMBOL = "@";

	public Player(Game game, int x, int y) {
		super(game, x, y);
		this.game = game;
		initialize(x, y);
	}

	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;
		actualCoins = INITIAL_COINS;
	}

	// MÉTODOS QUE GESTIONAN LAS COLISIONES
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

	@Override
	public boolean receiveShoot() {
		return false;
	}

	// MÉTODOS QUE GESTIONAN LOS EVENTOS
	@Override
	public void onEnter() {
	}

	@Override
	public void onDelete() {
	}

	// MÉTODOS QUE GESTIONAN EL MOVIMIENTO DEL JUGADOR
	public void moveDown() {
		if (y < game.getRoadWidth() - 1) {
			move(1, 1);
		} else {
			moveForward();
		}
	}

	public void moveUp() {
		if (y > 0) {
			move(1, -1);
		} else {
			moveForward();
		}
	}

	private void move(int dx, int dy) {
		doCollision();
		if (isAlive()) {
			x += dx;
			y += dy;
		}
		doCollision();
		game.update();
	}

	public void moveForward() {
		move(1, 0);
	}

	@Override
	public void update() {
	}

	public void jump() {
		x += 3;
	}

	// MÉTODOS QUE DEVUELVEN INFORMACIÓN DEL PLAYER

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

	@Override
	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	// MÉTODOS QUE MODIFICAN INFORMACIÓN DEL PLAYER
	public void addCoin(int c) {
		actualCoins += c;
	}

	public void removeCoins() {
		actualCoins = 0;
	}

	public void extractCoins(int c) {
		actualCoins -= c;
	}

	public void setDead() {
		alive = false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public boolean receiveWave() {
		return false;
	}

	@Override
	public boolean receiveThunder() {
		alive = false;
		return false;
	}
}