package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

/*
 * Si quisieramos que las granadas explotasen en cadena, solo tendriamos que:
 * 		1. Poner en receive explosion que ciclos = 0 y que devuelva true
 * 		2. en el explosion action, que la explosion no afecte a la propia granada (añadiendo i != j) al if
 */
import es.ucm.tp1.supercars.logic.instantActions.ExplosionAction;

public class Grenade extends GameObject {
	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";
	private final String GRENADE_SYMBOL = "ð";
	private int grenadeCycles = 4;

	public Grenade(Game game, int x, int lane) {
		super(game, x, lane);
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean isAlive() {
		return grenadeCycles > 0;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
		grenadeCycles--;
	}

	@Override
	public void onDelete() {
		game.execute(new ExplosionAction(x, y));
	}

	@Override
	protected String getSymbol() {
		return GRENADE_SYMBOL + "[" + grenadeCycles + "]";
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public boolean receiveWave() {
		x += 1;
		return true;
	}

	@Override
	public boolean receiveThunder() {
		return false;
	}

	@Override
	public String serialize() {
		return (super.serialize() + " " + grenadeCycles);
	}

}