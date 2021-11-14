package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ClearCommand extends Command{
	private static final String NAME = "clear";
	private static final String DETAILS = "Cheat [0]";
	private static final String SHORTCUT = "0";
	private static final String HELP = "Clears the road";
	private static final boolean PINTA_CARRETERA = true;

	public ClearCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.clearGameObjects();
		return PINTA_CARRETERA;
	}

}
