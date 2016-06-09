package org.akansha.myMontyHall;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.akansha.myMontyHall.Box.*;

public class BoxOperationsTest {
	private BoxOperations boxOpTest;

	@Before
	public void set() throws Exception {
		Box.setRandomSeed(1); // With seed 1 sequence of boxes will be
								// Box1,Box3,Box1
		boxOpTest = new BoxOperations();// priced box is now Box1
	}

	// test to verify Only one priced box
	@Test
	public void SelectBox() {
		BoxOperations selectedBox1 = boxOpTest.picBox(Box1);
		assertTrue("Box1 should be the priced box ", selectedBox1.isWinner());
		BoxOperations selectedBox2 = boxOpTest.picBox(Box2);
		assertFalse("Box2 should not be the priced box ", selectedBox2.isWinner());
		BoxOperations selectedBox3 = boxOpTest.picBox(Box3);
		assertFalse("Box2 should not be the priced box ", selectedBox3.isWinner());
	}

	// test to verify shuffle change the priced box priced box
	@Test
	public void shuffle() {
		BoxOperations shuffled = boxOpTest.shuffle();
		BoxOperations selectedBox1 = shuffled.picBox(Box1);
		BoxOperations selectedBox2 = shuffled.picBox(Box2);
		assertFalse("Box 1 is still priced box", selectedBox1.isWinner());
		assertFalse("Box 2 should  be the priced box", selectedBox2.isWinner());
		BoxOperations selectedBox3 = shuffled.picBox(Box3);
		assertTrue("Box 3 should  be the priced box", selectedBox3.isWinner());
		BoxOperations shuffledNew = shuffled.shuffle();
		assertTrue("Box 3 is new priced box", selectedBox3.isWinner());
		BoxOperations selectedBox4 = shuffledNew.picBox(Box2);
		assertFalse("Box 2 is new priced box", selectedBox4.isWinner());
	}
	
	//change of mind when Selected box is  priced one
	@Test
	public void changMindWin(){
		BoxOperations selectedBox =  boxOpTest.picBox(Box3);
		BoxOperations chgd= selectedBox.changeMind();
		assertTrue(chgd.isWinner());		
	}

	
	//change of mind when Selected box is not priced one
	@Test
	public void changMindLoose(){
		BoxOperations selectedPricedBox =  boxOpTest.picBox(Box1);
		BoxOperations chgd= selectedPricedBox.changeMind();
		assertFalse(chgd.isWinner());		
	}
}
