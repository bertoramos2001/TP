package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantActions.ExplosionAction;

public class Grenade extends GameObject{
	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";
	private final String GRENADE_SYMBOL = "ð";
	private int numCycles = 4;
	
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
		return numCycles > 0;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
		numCycles--;
	}

	@Override
	public void onDelete() {
		game.execute(new ExplosionAction(x, y));
	}
	
	@Override
	protected String getSymbol() {
		return GRENADE_SYMBOL + "[" + numCycles + "]";
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

}
