package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {
	private static final String NAME = "exit";
	private static final String DETAILS = "[e]xit";
	private static final String SHORTCUT = "e";
	private static final String HELP = "exit game";

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
