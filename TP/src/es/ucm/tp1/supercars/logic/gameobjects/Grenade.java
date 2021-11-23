package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject{
	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";
	private final String GRENADE_SYMBOL = "ð";

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
		// TODO falta implementar
		return true;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
		// TODO:falta implementar
	}

	@Override
	public void onDelete() {
		//TODO: aquí se realiza la explosión de la granada
	}
	
	@Override
	protected String getSymbol() {
		return GRENADE_SYMBOL;
	}

	@Override
	public boolean receiveExplosion() {
		return false; 
	}
	
	@Override
	public boolean receiveWave() {
		// TODO no sé si la recibe
		return true;
	}

}
