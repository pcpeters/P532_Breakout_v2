package com.oosd;

import static org.junit.Assert.*;

import org.junit.Test;

public class BallTest {
	private Ball ball = new Ball(0, 0, 0, 0, null);
	@Test
	public void testBall() {
		boolean expectedOutput = true;
		boolean actualOutput = ball.isOnScreen();
		assertEquals("They are not equal", expectedOutput, actualOutput);
	
	}
	
}
