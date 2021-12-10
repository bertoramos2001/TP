package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ShootAction implements InstantAction {
	
	private int i;
	private boolean found;
	private GameObject o;

	@Override
	public void execute(Game game) {
		i = game.getPlayerPositionX();
		found = false;
		while(!found && i < (game.getVisibility() + game.getPlayerPositionX())) {
			o = game.getObjectInPosition(i, game.getPlayerPositionY());
			if (o != null) {
				found = o.receiveShoot();
			}
			i++;
		}
	}

}