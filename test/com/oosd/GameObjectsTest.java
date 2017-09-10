package com.oosd;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;

import org.junit.Test;

public class GameObjectsTest {
	private GameObjects gameObjects = new GameObjects(0, 0, 0, 0, null);

	@Test
	public void testGetX() {
		int expectedOutput = 0;
		int actualOutput = gameObjects.getX();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testGetY() {
		int expectedOutput = 0;
		int actualOutput = gameObjects.getY();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetWidth() {
		int expectedOutput = 0;
		int actualOutput = gameObjects.getWidth();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetHeight() {
		int expectedOutput = 0;
		int actualOutput = gameObjects.getHeight();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetColor() {
		Color expectedOutput = null;
		Color actualOutput = gameObjects.getColor();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetRectangle() {
		Rectangle expectedOutput = new Rectangle(0,0,0,0);
		Rectangle actualOutput = gameObjects.getRectangle();
		assertEquals(expectedOutput, actualOutput);
	}
}
