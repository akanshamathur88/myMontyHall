package org.akansha.myMontyHall;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.akansha.myMontyHall.Box.*;
public class BoxTest {

	@Test
	public void test() {
		Box.setRandomSeed(1); // With seed 1 sequence of boxes will be Box1,Box3,Box1
		assertEquals("First Box should be box1", Box1, Box.randomBox());
		assertEquals("Second Box should be box3", Box3, Box.randomBox());
		assertEquals("Third Box should be box1", Box1, Box.randomBox());
	
		
	}

}
