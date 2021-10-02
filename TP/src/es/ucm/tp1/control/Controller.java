package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
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
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		
		long startTime = System.currentTimeMillis();
		// TODO fill your code
		printGame();
		boolean doExit = false;
		while (!doExit) {
			System.out.print(PROMPT);
			String line = scanner.nextLine();
			switch (line.toLowerCase()) {
			case "e":
			case "exit":
				System.out.println("[GAME OVER] Player leaves the game");
				doExit = true;
				break;
			case "n":
			case "none":
			case "":
				game.moveForward();
				printGame();
				break;
			case "q":
				game.moveUp();
				printGame();
				break;
			case "a":
				game.moveDown();
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
				//TODO programar el reset	
				break;
			case "t":
			case "test":
				game.toggleTest();
				break;
			default:
				System.out.println("[ERROR] " + UNKNOWN_COMMAND_MSG);
				break;
			}
		}
		game.update();
	}

}
