package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command  implements Buyable {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>";
	private static final String SHORTCUT = "g";
	private static final String HELP = "add a grenade in position x, y";
	private boolean PINTA_CARRETERA = true;
	private final int GRENADE_COST = 3;
	
	private Integer grenadeX, grenadeY;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {	
		if (grenadeX <= game.getVisibility() && grenadeY <= game.getRoadWidth() && grenadeY >= 0 && game.getObjectInPosition(grenadeX + game.getPlayerPositionX(), grenadeY) == null) {
			if (buy(game)) {
				game.addObject(new Grenade(game, grenadeX + game.getPlayerPositionX(), grenadeY));
				game.update();
				PINTA_CARRETERA = true;
			} else {
				System.out.println("[ERROR]: Failed to add grenade\n");
				PINTA_CARRETERA = false;
			}
		} else {			
			System.out.println("Invalid position.");
			System.out.println("[ERROR]: Failed to add grenade\n");
			PINTA_CARRETERA = false;
		}
		
		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				try {
					grenadeX = Integer.parseInt(words[1]);
					grenadeY = Integer.parseInt(words[2]);
				} 
				catch (NumberFormatException e) {
					return null;
				}
				return this;
			}
		}
		return null;
	}

	@Override
	public int cost() {
		return GRENADE_COST;
	}
	
}