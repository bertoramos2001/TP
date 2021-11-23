package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends Obstacles {
	
	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down\n";
	private final String PEDESTRIAN_SYMBOL = "☺";
	private boolean isDown = true;
	private final int LIVES = 0;

	public Pedestrian(Game game, int x, int lane) {
		super(game, x, lane);
		symbol = PEDESTRIAN_SYMBOL;
		lives = LIVES;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.setDead();
		player.removeCoins();
		lives -= 1;
		return false;
	}

	@Override
	public boolean receiveShoot() {
		lives -= 1;
		//TODO: creo que pierde monedas
		return false;
	}
	//TODO: igual que con wall, ver si explosion funciona con el del padre

	@Override
	public void update() {	
		
		if(isDown) {
			y = y + 1;
		}
		else {
			y = y - 1;
			if( y < 0)
				y = -y;
		}
		if(y == 0 || y == 2)
			isDown = !isDown;
	}
}
