package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class WaveAction implements InstantAction {
	private int actPos;

	@Override
	public void execute(Game game) {
		actPos = game.getPlayerPositionX();

		for (int i = game.getPlayerPositionX() + game.getVisibility(); i > actPos; i--) {
			for (int j = 0; j < game.getRoadWidth(); j++) {
				Collider c = game.getColliderInPosition(i, j);
				if (c == null) {
					if (game.getObjectInPosition(i - 1, j) != null) {
						game.getObjectInPosition(i - 1, j).receiveWave();
					}
				}
			}
		}
	}

}