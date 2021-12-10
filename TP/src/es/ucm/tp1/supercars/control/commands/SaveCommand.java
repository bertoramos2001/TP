package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class SaveCommand extends Command {
	
	private static final String NAME = "save";
	private static final String DETAILS = "sa[v]e <filename>";
	private static final String SHORTCUT = "v";
	private static final String HELP = "Save the state of the game to a file.";
	private static final boolean PINTA_CARRETERA = true;

	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}