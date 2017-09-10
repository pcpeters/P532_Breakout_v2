package com.oosd;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameObjectCoordinatesTest {
	private GameObjectCoordinates gameObjectCoordinates = new GameObjectCoordinates();
	
	@Test
	public void testGameFlag() {
		int expectedOutput = 0;
		int actualOutput = gameObjectCoordinates.getGameFlag();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGameBallX() {
		int expectedOutput = 0;
		int actualOutput = gameObjectCoordinates.getBallX();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGameBallY() {
		int expectedOutput = 0;
		int actualOutput = gameObjectCoordinates.getBallY();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGamePaddleX() {
		int expectedOutput = 0;
		int actualOutput = gameObjectCoordinates.getPaddleX();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGamePaddleY() {
		int expectedOutput = 0;
		int actualOutput = gameObjectCoordinates.getPaddleY();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testIsBrickDestroyed() {
		ArrayList<Boolean> expectedOutput = null;
		ArrayList<Boolean> actualOutput = gameObjectCoordinates.isBrickDestroyed();
		assertEquals(expectedOutput, actualOutput);
	}
}
