package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantActions.ShootAction;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;

public class ShootCommand extends Command implements Buyable {

	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "shoot bullet";
	private boolean PINTA_CARRETERA = true;
	private final int SHOOT_COST = 1;
	private static final String FAILED_MSG = "Failed to shoot";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			// buy comprueba excepciones
			buy(game);
			game.execute(new ShootAction());
			game.update();

		} catch (CommandExecuteException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: " + FAILED_MSG));
		}
		return PINTA_CARRETERA;
	}

	@Override
	public int cost() {
		return SHOOT_COST;
	}
}