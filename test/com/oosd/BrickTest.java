package com.oosd;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrickTest {
	private Brick brick = new Brick(0, 0, 0, 0, null);
	@Test
	public void testBrickDestroyed() {
		boolean expectedOutput = false;
		boolean actualOutput = brick.isDestroyed();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testBricksGetHit() {
		int expectedOutput = 0;
		int actualOutput = brick.getHits();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testBricksHitTop() {
		boolean expectedOutput = true;
		boolean actualOutput = brick.hitTop(0, 0);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testBricksHitsBottom() {
		boolean expectedOutput = true;
		boolean actualOutput = brick.hitBottom(0,0);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testBricksHitsLeft() {
		boolean expectedOutput = true;
		boolean actualOutput = brick.hitLeft(0,0);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testBricksHitsRight() {
		boolean expectedOutput = true;
		boolean actualOutput = brick.hitRight(0,0);
		assertEquals(expectedOutput, actualOutput);
	}

}
