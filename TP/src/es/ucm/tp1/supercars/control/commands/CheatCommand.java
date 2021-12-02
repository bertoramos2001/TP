package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command {
	
	private static final String NAME = "cheat";
	private static final String DETAILS = "Cheat [1..5]";
	private static final String SHORTCUT = "1 2 3 4 5";
	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";
	private static final boolean PINTA_CARRETERA = true;
	private int idComando;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		int lastColumn = game.getLastVisibleColumn();
		game.clearColumn(lastColumn);
		GameObjectGenerator.forceAdvanceObject(game, idComando, lastColumn);
		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) {
		if (words.length == 1) {
			try {
				idComando = Integer.parseInt(words[0]);
			} 
			catch (Exception e) {
				return null;
			}
			if (idComando >= GameObjectGenerator.MIN_OBJECT_ID && idComando <= GameObjectGenerator.MAX_OBJECT_ID) {
				return this;
			} else {
				return null;
			}
		}
		return null;
	}
}
