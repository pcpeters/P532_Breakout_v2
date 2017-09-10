package com.oosd;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuButtonsTest {
	private MenuButtons menuButtons = new MenuButtons(null);
	
	@Test
	public void testPauseButtons() {
		boolean expectedOutput = false;
		boolean actualOutput = menuButtons.isPaused();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testStartButton() {
		boolean expectedOutput = false;
		boolean actualOutput = menuButtons.isStart();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testlayoutState() {
		int expectedOutput = 0;
		int actualOutput = menuButtons.getLayoutState();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testgameState() {
		int expectedOutput = 0;
		int actualOutput = menuButtons.getGameState();
		assertEquals(expectedOutput, actualOutput);
	}
}
