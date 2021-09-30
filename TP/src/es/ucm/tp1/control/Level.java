package es.ucm.tp1.control;

import java.util.Random;

public enum Level {

	TEST(10, 3, 8, 0.5, 0), EASY(30, 3, 8, 0.5, 0.5), HARD(100, 5, 6, 0.7, 0.3);

	public int length;

	private int width;

	private int visibility;

	private double coinFrequency;

	private double obstacleFrequency;

	public static Random ran = new Random();

	private Level(int length, int width, int visibility, double obstacleFrequency, double coinFrequency) {
		this.length = length;
		this.width = width;
		this.visibility = visibility;
		this.obstacleFrequency = obstacleFrequency;
		this.coinFrequency = coinFrequency;
	}

	// TODO fill your code

	public int getRandomLane() {
		int x = ran.nextInt(3);
		return x;
	}

	public double coinFrequency() {
		return this.coinFrequency;
	}

	public double obstacleFrequency() {
		return this.obstacleFrequency;
	}

	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}
}
