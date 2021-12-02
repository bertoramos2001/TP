package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command {
	private static final String NAME = "dump";
	private static final String DETAILS = "[d]ump <filename>";
	private static final String SHORTCUT = "d";
	private static final String HELP = "Shows the content of a saved file";
	private static final boolean PINTA_CARRETERA = true;

	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
