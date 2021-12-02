package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command {
	private static final String NAME = "record";
	private static final String DETAILS = "rec[o]rd";
	private static final String SHORTCUT = "o";
	private static final String HELP = "show level record";
	private static final boolean PINTA_CARRETERA = true; //TODO: igual no es asi

	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
