package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction {
	private int actPos;
	private GameObject o;
	
	@Override
	public void execute(Game game) {
		actPos = game.getPlayerPositionX();
		
		for (int i = game.getPlayerPositionX() + game.getVisibility() - 1; i > actPos; i--) {
			for (int j = 0; j < game.getRoadWidth(); j++) {
				o = game.getObjectInPosition(i, j);
				if (o == null) {
					if (game.getObjectInPosition(i - 1, j) != null) {
						//TODO: hacerlo como en errores frecuentes, con un collider y que cada objeto mire lo que tiene detras
						game.getObjectInPosition(i - 1, j).receiveWave();
					}
				}
			}
		}
	}

}