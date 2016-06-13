package org.akansha.myMontyHall;

public class BoxOperations {
	private final Box pricedBox;
	private final Box selectedBox;

	// Will set up a new BoxOperations with a random priced Box and no selected
	// box.

	public BoxOperations() {
		pricedBox = Box.randomBox();
		selectedBox = null;
	}

	// Copy constructor used for setting the selectedBox

	private BoxOperations(BoxOperations fromSet, Box selectedBox) {
		pricedBox = fromSet.pricedBox;
		this.selectedBox = selectedBox;
	}

	// Picks a box with guess contains the prize

	public BoxOperations picBox(Box picked) {
		return new BoxOperations(this, picked);
	}

	// This method checks if the selected box is the priced box
	public boolean isWinner() {
		return selectedBox == pricedBox;
	}

	// This method put the price in a random box

	public BoxOperations shuffle() {
		return new BoxOperations();
	}
	// This method change selected box ,that is if you picked a winning box, you
	// change to an non winning box and vice verse.

	public BoxOperations changeMind() {
		Box changedBox = isWinner() ? null : pricedBox;
		return new BoxOperations(this, changedBox);
	}
}
