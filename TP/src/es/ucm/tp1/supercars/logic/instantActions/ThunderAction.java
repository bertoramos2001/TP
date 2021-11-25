package es.ucm.tp1.supercars.logic.instantActions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction {
	
	private int x, y;
	GameObject o;
	private String s;

	@Override
	public void execute(Game game) {
		x = game.getRandomVisibleColumn();
		y = game.getRandomLane();
		s = "Thunder hit position: (" + x + " , " + y + ")";
		
		o = game.getObjectInPosition(game.getPlayerPositionX() + x, y);
		
		if (o != null) {
			s += " -> " + o.toString();
			o.receiveThunder();
		}
		
		System.out.println(s);
	}

}
