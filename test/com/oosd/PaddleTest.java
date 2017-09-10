package com.oosd;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaddleTest {
	private Paddle paddle = new Paddle(0, 0, 0, 0, null);

	@Test
	public void testhitPaddle() {
		boolean expectedOutput = true;
		boolean actualOutput = paddle.hitPaddle(0,0);
		assertEquals(expectedOutput, actualOutput);
	}

}
