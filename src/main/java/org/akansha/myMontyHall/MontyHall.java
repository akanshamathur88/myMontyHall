package org.akansha.myMontyHall;

//This is simulation of Monty hall problem
public class MontyHall {
	private BoxOperations boxOperation = new BoxOperations();
	private int trials = 10000;

	private void simulate() {

		int winsWithoutChange = 0;
		int winsWithChange = 0;
		for (int i = 0; i < trials; i++) {
			if (boxOperation.shuffle().picBox(Box.randomBox()).isWinner()) {
				winsWithoutChange++;
			}
			if (boxOperation.shuffle().picBox(Box.randomBox()).changeMind().isWinner()) {
				winsWithChange++;
			}
		}
		int winsWithoutChangePercentage = winsWithoutChange * 100 / trials;
		int winsWithChangePercentage = winsWithChange * 100 / trials;

		System.out.println("Without Change, winning: " + winsWithoutChangePercentage + "%");
		System.out.println("With Change, winning: " + winsWithChangePercentage + "%");

	}

	public static void main(String[] args) {
		MontyHall montyHall = new MontyHall();
		montyHall.simulate();
	}
}
