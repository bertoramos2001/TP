package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;

public class GrenadeCommand extends Command  implements Buyable {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>";
	private static final String SHORTCUT = "g";
	private static final String HELP = "add a grenade in position x, y";
	private boolean PINTA_CARRETERA = true;
	private final int GRENADE_COST = 3;
	private static final String FAILED_MSG = "Failed to add grenade";
	private static final String FAIL_COOORDINATES_MSG = "The coordinates of the position must be integers";
	private static final String COMPLEM_MSG_GRENADE = " for grenade command: ";
	
	private Integer grenadeX, grenadeY;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {	
	try {
		game.inValidPosition(grenadeX, grenadeY);
		buy(game);

		game.addObject(new Grenade(game, grenadeX + game.getPlayerPositionX(), grenadeY));
		game.update();
		PINTA_CARRETERA = true;
				
		}catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		} catch (InvalidPositionException e) {	
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));	
		}

		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 3) {
				throw new CommandParseException(String.format("[ERROR]: %s", INCORRECT_NUMBER_OF_ARGS_MSG + COMPLEM_MSG_GRENADE + DETAILS));
			} else {
				try {
					grenadeX = Integer.parseInt(words[1]);
					grenadeY = Integer.parseInt(words[2]);
				} 
				catch (NumberFormatException e) {
					throw new CommandParseException(String.format("[ERROR]: %s", FAIL_COOORDINATES_MSG));
					
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