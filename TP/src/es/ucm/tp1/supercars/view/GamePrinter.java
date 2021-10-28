package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.*;

public class GamePrinter {
	
	private static final String SPACE = " ";
	private static final String VERTICAL_DELIMITER = "|";
	private static final String ROAD_BORDER_PATTERN = "═";
	private static final String LANE_DELIMITER_PATTERN = "─";
	
	private static final int CELL_SIZE = 7;
	private static final int MARGIN_SIZE = 2;

	private String indentedRoadBorder;
	private String indentedLlanesSeparator;
	private String margin;

	private static final String CRASH_MSG = String.format("Player crashed!%n");
	private static final String WIN_MSG = String.format("Player wins!%n");
	private static final String DO_EXIT_MSG = "Player leaves the game";
	private static final String GAME_OVER_MSG = "[GAME OVER] ";

	public String newLine;

	protected Game game;

	public GamePrinter(Game game) {
		this.game = game;

		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN
				+ StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, game.getVisibility() - 1)
				+ laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine = System.getProperty("line.separator");

		newLine = System.getProperty("line.separator");
	}
	
	private String getInfo() {
		
		String info = String.format("Distance: %d\nCoins: %d\nCycle: %d\nTotal obstacles: %d\nTotal coins: %d",
				game.getDistanceToEnd(), game.getActualCoins(), game.getCycle(), game.getTotalObstacles(),game.getTotalCoins());
		
		return info;
	}
	
	private String getTimeInfo() {
		String info = String.format("\nElapsed Time: %.2f s", ((double)System.currentTimeMillis() - game.getTime()) / 1000);	
		return info;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		String verticalDelimiter = SPACE;

		str.append(getInfo());
		
		if(!game.testMode())
			str.append(getTimeInfo());
		
		str.append(indentedRoadBorder);

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = game.getPlayerPositionX(); x < game.getVisibility(); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE)).append(verticalDelimiter);
			}
			if (y < game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
}
