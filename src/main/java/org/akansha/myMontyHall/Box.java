package org.akansha.myMontyHall;

import java.util.Random;

public enum Box {
	Box1, Box2, Box3;
	public static Random random = new Random();

	public static void setRandomSeed(long seed) {
		Box.random.setSeed(seed);
	}

	// This method gives random boxes when called.
	public static Box randomBox() {
		Box[] boxes = Box.values();
		int box = Math.abs(random.nextInt()) % boxes.length;
		return boxes[box];
	}
}
