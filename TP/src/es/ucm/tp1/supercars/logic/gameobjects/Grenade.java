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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected String getSymbol() {
		return GRENADE_SYMBOL;
	}

	@Override
	public boolean receiveExplosion() {
		return false; 
	}

}
