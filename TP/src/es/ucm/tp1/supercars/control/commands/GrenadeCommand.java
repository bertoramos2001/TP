package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;

public class GrenadeCommand extends Command {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>";
	private static final String SHORTCUT = "g";
	private static final String HELP = "add a grenade in position x, y";
	private static final boolean PINTA_CARRETERA = false;
	
	private Integer grenadeX, grenadeY;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		
		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				grenadeX = Integer.parseInt(words[1]);
				grenadeY = Integer.parseInt(words[2]);
				return this;
			}
		}
		return null;
	}
	
}
