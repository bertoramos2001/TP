package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";
	private static final String DEBUG_MSG = "[DEBUG] Executing: ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private final int NUM_USER_EXIT = 1;
	private final int NUM_USER_WIN = 2;
	private final int NUM_USER_CRASH = 3;

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobject info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);		
	}

	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage(int numError) {
		System.out.println(printer.endMessage(numError));
	}

	public void run() {	
		game.startTimer();
		printGame();
		boolean doExit = false;
		while (!doExit) {
			System.out.println(PROMPT);
			System.out.print(DEBUG_MSG);
			String line = scanner.nextLine();
			System.out.print(line + "\n");
			switch (line.toLowerCase()) {
			case "e":
			case "exit":
				printEndMessage(NUM_USER_EXIT);
				doExit = true;
				break;
			case "n":
			case "none":
			case "":
				game.update("n");
				printGame();
				break;
			case "q":
				game.update("q");
				printGame();
				break;
			case "a":
				game.update("a");
				printGame();
				break;
			case "h":
			case "help":
				for (int i = 0; i < HELP.length; i++) {
					System.out.println(HELP[i]);
				}
				break;
			case "i":
			case "info":
				System.out.println("Available objects:");
				game.getObjectsInfo();
				break;
			case "r":
			case "reset":
				game.restart();
				game.startTimer();
				printGame();
				break;
			case "t":
			case "test":
				game.testModeON();
				printGame();
				break;
			default:
				System.out.println("[ERROR]: " + UNKNOWN_COMMAND_MSG + "\n");
				break;
			}
			if (game.getPosition() == game.getRoadLength() + 1) {
				printEndMessage(NUM_USER_WIN);
				doExit = true;
			} else if (!game.getPlayerAlive()) {
				printEndMessage(NUM_USER_CRASH);
				doExit = true;
			}
			game.addCycle();
		}
	}

}
