package com.oosd;

public interface Constants {

	// Window Size Constants
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 500;

	// Ball Constants
	public static final int BALL_WIDTH = 10;
	public static final int BALL_HEIGHT = 10;
	public static final int BALL_RIGHT_BOUND = 490;
	public static final int BALL_X_START = 245;
	public static final int BALL_Y_START = 245;

	// Paddle Constants
	public static final int PADDLE_WIDTH = 70;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_RIGHT_BOUND = 430;
	public static final int PADDLE_X_START = 225;
	public static final int PADDLE_Y_START = 350;
	public static final int PADDLE_MIN = 35;
	public static final int PADDLE_MAX = 140;

	// Bricks Constants
	public static final int BRICK_WIDTH = 50;
	public static final int BRICK_HEIGHT = 25;
	public static final int MAX_BRICKS = 50;
	public static final int NO_BRICKS = 0;
	public static final int BRICK_ROWS = 10;
	public static final int BRICK_COLUMNS = 5;
	public static final int TOTALBRICKS = BRICK_ROWS * BRICK_COLUMNS;

}