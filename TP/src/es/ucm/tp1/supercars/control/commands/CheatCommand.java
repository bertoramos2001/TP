package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command {
	//TODO: cuando llamemos al forceAdvanceObject, hay que llamarle con la ultima columna visible siempre
	// usando esto: GameObjectGenerator.forceAdvanceObject(this, 2, getPlayerPositionX() + getVisibility() - 1);
	
	private static final String NAME = "exit";
	private static final String DETAILS = "[e]xit";
	private static final String SHORTCUT = "e";
	private static final String HELP = "exit game";
	private static final boolean PINTA_CARRETERA = false;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
