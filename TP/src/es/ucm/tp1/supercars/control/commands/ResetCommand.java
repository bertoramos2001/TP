package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class ResetCommand extends Command {
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset [<level> <seed>]";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";
	
	private Long newSeed;
	private Level newLevel;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		newSeed = null;
		newLevel = null;
	}

	@Override
	public boolean execute(Game game) {
		if ((newLevel != null) || (newSeed != null)) {
			game.initialize(newSeed, newLevel);
		} else {
			game.initialize();
		}
		
		return true;
	}
	
	@Override
	//TODO: hcer dos reset: uno con atributos y otro sin ellos, desde el que tiene atributos se llama al que si los tiene en game despues de actualizar seed y level
	protected Command parse(String[] words) {
		if (words.length == 3) {
			if (matchCommandName(words[0])) {
				newLevel = Level.valueOfIgnoreCase(words[1]);
				newSeed = Long.parseLong(words[2]);
				
				return this;
			} else {
				return null;
			}
		} else {
			return super.parse(words);
		}
	}
}
