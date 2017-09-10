package com.oosd;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {
	private GameBoard gameBoard = new GameBoard();
	@Test
	public void testgameFlag() {
		int expectedOutput = 0;
		int actualOutput = gameBoard.getGameFlag();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testloadGameFlag() {
		int expectedOutput = 0;
		int actualOutput = gameBoard.getLoadGameFlag();
		assertEquals(expectedOutput, actualOutput);
	}

}
