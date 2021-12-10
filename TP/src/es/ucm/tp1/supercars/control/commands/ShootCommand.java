package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantActions.ShootAction;

public class ShootCommand extends Command implements Buyable{
	
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "shoot bullet";
	private boolean PINTA_CARRETERA = true;
	private final int SHOOT_COST = 1;

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
			game.execute(new ShootAction());
			game.update();
		} else {
			System.out.println("[ERROR]: Failed to shoot\n");
			return false;
		}
		return PINTA_CARRETERA;
	}

	@Override
	public int cost() {
		return SHOOT_COST;
	}
}