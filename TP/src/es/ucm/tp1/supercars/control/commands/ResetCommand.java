package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:");

		// TODO Add your code

		System.out.println(buffer.toString());

		return false;
	}
}
