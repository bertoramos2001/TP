package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.utils.StringUtils;

public class ThunderAction implements InstantAction {

	private int x, y, relativeX;
	GameObject o;

	@Override
	public void execute(Game game) {
		x = game.getRandomVisibleColumn();
		y = game.getRandomLane();
		System.out.print(String.format("Thunder hit position: (%d , %d)", x, y));

		// o = game.getObjectInPosition(game.getPlayerPositionX() + x, y);

		relativeX = game.getPlayerPositionX() + x;
		Collider c = game.getColliderInPosition(relativeX, y);

		if (c != null) {
			c.receiveThunder();
		}
		System.out.print(StringUtils.LINE_SEPARATOR);
	}

}