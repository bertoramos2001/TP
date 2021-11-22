package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantActions.ShootAction;

public class ShootCommand extends Command {
	
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "shoot bullet";
	private static final boolean PINTA_CARRETERA = true;

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		//TODO: queda llamar bien al shoot
		game.execute(new ShootAction());
		return PINTA_CARRETERA;
	}
}
