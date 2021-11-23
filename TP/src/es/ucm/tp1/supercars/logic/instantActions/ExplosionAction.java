package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ExplosionAction implements InstantAction {
	
	private int x, y;
	private GameObject o;
	
	public ExplosionAction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(Game game) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				o = game.getObjectInPosition(i, j);
				if (o != null) {
					o.receiveExplosion();
				}
			}
		}
	}

}
