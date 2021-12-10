package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {
	private static final String NAME = "r";
	private static final String DETAILS = "[r]eset [<level> <seed>]";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";
	private static final boolean PINTA_CARRETERA = true;
	private static final String UNKNOWN_LEVEL_MSG = "Level must be one of: TEST, EASY, HARD, ADVANCED\n";
	
	private Long newSeed;
	private Level newLevel;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		newSeed = null;
		newLevel = null;
	}

	@Override
	public boolean execute(Game game) {
		if ((newLevel != null) && (newSeed != null)) {
			game.initialize(newSeed, newLevel);
		} else {
			game.initialize();
		}
		
		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) {
		if (words.length == 3) {
			if (matchCommandName(words[0])) {
				newLevel = Level.valueOfIgnoreCase(words[1]);
				newSeed = Long.parseLong(words[2]);
				
				if (newLevel == null) {
					System.out.println("[ERROR]: Command r: " + UNKNOWN_LEVEL_MSG);
					return null;
				}
				return this;
			} else {
				return null;
			}
		} else {
			return super.parse(words);
		}
	}
}