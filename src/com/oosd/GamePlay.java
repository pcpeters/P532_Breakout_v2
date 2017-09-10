package com.oosd;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class GamePlay implements Constants
{
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	
	private int currentSecond, currentMinute;
	private String timeForGameTimer;
	private int timerTracker = 0;
	private int layoutState = 0;
	
	private int gameFlag; // 0 - init, 1 - start, 2 - gameover
	

	/*
     * Function Name: GamePlay
     * Parameters In: None
     * Parameters Out: None
     * Description: Initializes a paddle, a ball and bricks and draws the bricks.
     */
	public GamePlay()
	{
		this.ball = new Ball(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, Color.BLACK);
		this.paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);
		this.bricks = new Brick[Constants.TOTALBRICKS];
		
		this.setGameFlag(1);	//Game set to normal play
		makeBricks();
	}


	/*
     * Parameters In: Only in case of setters
     * Parameters Out: Only in case of getters
     * Description: Getters and Setters for class members.
     */
	public int getCurrentSecond()
	{
		return currentSecond;
	}

	public void setCurrentSecond(int currentSecond) 
	{
		this.currentSecond = currentSecond;
	}

	public int getCurrentMinute() 
	{
		return currentMinute;
	}

	public void setCurrentMinute(int currentMinute) 
	{
		this.currentMinute = currentMinute;
	}

	public String getTimeForDisplayClock() 
	{
		return timeForGameTimer;
	}

	public void setTimeForDisplayClock(String timeForDisplayClock) 
	{
		this.timeForGameTimer = timeForDisplayClock;
	}
	
	public int getTimerTracker() 
	{
		return timerTracker;
	}

	public void setTimerTracker(int timerTracker) 
	{
		this.timerTracker = timerTracker;
	}

	public int getGameFlag() 
	{
		return gameFlag;
	}

	public void setGameFlag(int gameFlag) 
	{
		this.gameFlag = gameFlag;
	}

	public Ball getBall() 
	{
		return ball;
	}

	public void setBall(Ball ball) 
	{
		this.ball = ball;
	}

	public Paddle getPaddle() 
	{
		return paddle;
	}

	public void setPaddle(Paddle paddle) 
	{
		this.paddle = paddle;
	}

	public Brick[] getBricks() 
	{
		return bricks;
	}

	public void setBricks(Brick[] bricks) 
	{
		this.bricks = bricks;
	}

	public int getLayoutState() 
	{
		return layoutState;
	}

	public void setLayoutState(int layoutState) 
	{
		this.layoutState = layoutState;
	}
	
	
	/*
     * Function Name: makeBricks
     * Parameters In: None
     * Parameters Out: None
     * Description: Creates different objects of brick and paints them on canvas.
     */
	private void makeBricks() 
	{
		int brickIndex = 0;
		for (int i = 0; i < Constants.BRICK_ROWS; i++) 
		{
			for (int j = 0; j < Constants.BRICK_COLUMNS; j++) 
			{				
				bricks[brickIndex] = new Brick((i * BRICK_WIDTH), ((j * BRICK_HEIGHT) + (BRICK_HEIGHT / 2)), BRICK_WIDTH - 5, BRICK_HEIGHT - 5, Color.GRAY);
				brickIndex++;
			}
		}
	}

	/*
     * Function Name: getGameObjectList
     * Parameters In: None
     * Parameters Out: None
     * Description: Adds objects of flag, ball, bricks, paddle, timer and layout in the list.
     */
	public ArrayList<Object> getGameObjectList() 
	{
		ArrayList<Object> gameObjectList = new ArrayList<Object>();
		
		gameObjectList.add(Integer.valueOf(this.getGameFlag()));
		gameObjectList.add(this.getBall());
		gameObjectList.add(this.getBricks());
		gameObjectList.add(this.getPaddle());
		gameObjectList.add(this.timeForGameTimer);
		gameObjectList.add(this.getLayoutState());
		
		return gameObjectList;
	}

	/*
     * Function Name: getBrickFlags
     * Parameters In: None
     * Parameters Out: ArrayList<Boolean>
     * Description: List of brick status to check is brick is destroyed.
     */
	
	public ArrayList<Boolean> getBrickFlags() 
	{
		ArrayList<Boolean> brickFlags = new ArrayList<Boolean>();
		for (int i = 0; i < TOTALBRICKS; i++) 
		{
			brickFlags.add(i, this.bricks[i].isDestroyed());
		}
		return brickFlags;
	}

	/*
     * Function Name: getGameStateList
     * Parameters In: None
     * Parameters Out: GameState
     * Description: Get game state of every object in a list.
     */
	public GameState getGameStateList() 
	{
		GameState gameStateList = new GameState(this.getBall().getX(),
				this.getBall().getY(), this.getBall().getXDir(), 
				this.getBall().getYDir(),
				this.getPaddle().getX(), this.getPaddle().getY(), 
				this.getGameFlag(),
				this.getTimeForDisplayClock(), this.getBrickFlags(),
				this.getLayoutState());
		
		return gameStateList;
	}

	/*
     * Function Name: saveGameState
     * Parameters In: GameState
     * Parameters Out: None
     * Description: Sets the location of all game objects.
     */
	public void saveGameState(GameState gameStateList) 
	{
		//Save state of ball
		getBall().setX(gameStateList.getBallX());
		getBall().setY(gameStateList.getBallY());
		getBall().setXDir(gameStateList.getBallXDir());
		getBall().setYDir(gameStateList.getBallYDir());
		
		//Save state of paddle
		getPaddle().setY(gameStateList.getPaddleY());
		getPaddle().setX(gameStateList.getPaddleX());
		
		//Save gameflag
		setGameFlag(gameStateList.getGameFlag());
		
		setTimeForDisplayClock(gameStateList.getSetTimeForDisplayClock());
		
		setLayoutState(gameStateList.getLayoutState());
		
		//Save state of bricks
		ArrayList<Boolean> getBrickFlags = gameStateList.getIsBrickDestroyed();
		for (int i = 0; i < TOTALBRICKS; i++) 
		{
			this.bricks[i].setDestroyed(getBrickFlags.get(i));
		}
	}
	
	/*
     * Function Name: moveGameObjects
     * Parameters In: None
     * Parameters Out: None
     * Description: Move game ball and paddle.
     */
	public void moveGameObjects() 
	{
		if (this.getGameFlag() == 1) 
		{
			this.ball.move();
			this.paddle.move();
			
			checkCollision();
		}
	}

	/*
     * Function Name: refresh
     * Parameters In: None
     * Parameters Out: None
     * Description: Update or refresh the timer variables.
     */
	private void refresh() 
	{
		currentMinute++;
		currentSecond = 0;
	}

	/*
     * Function Name: start
     * Parameters In: None
     * Parameters Out: None
     * Description: Update or refresh current minute.
     */
	public void start() 
	{
		currentMinute++;
	}

	/*
     * Function Name: reset
     * Parameters In: None
     * Parameters Out: None
     * Description: Resets the clock.
     */
	public void reset() 
	{
		currentMinute = -1;
		currentSecond = 0;
		timeForGameTimer = "00:00";
		timerTracker = 0;
	}

	/*
     * Function Name: updateGameTimer
     * Parameters In: None
     * Parameters Out: None
     * Description: Updated the game timer.
     */
	public String updateGameTimer() 
	{
		timerTracker++;
		if (timerTracker >= 100) 
		{
			if (currentSecond == 60) 
			{
				refresh();
			}
			timeForGameTimer = String.format("%02d:%02d", currentMinute, currentSecond);
			currentSecond++;
			timerTracker = 0;
		}
		return timeForGameTimer;
	}

	/*
     * Function Name: checkCollision
     * Parameters In: None
     * Parameters Out: None
     * Description: Checks the game over and ball collision with the paddle.
     */
	public void checkCollision() 
	{
		//Game over
		if (ball.getY() + ball.getHeight() > (Constants.WINDOW_HEIGHT - 82))
		{
			setGameFlag(2);
		}
		
		//Change ydir if ball collides with paddle
		if(((ball.getX() + ball.getWidth() >= paddle.getX()) && (ball.getX() <= paddle.getX() + paddle.getWidth())) &&
				(((ball.getY() + ball.getHeight()) >= paddle.getY())) && (ball.getY() <= (paddle.getY() + paddle.getHeight())) ) {

			ball.setYDir(-ball.getYDir());
		}		
		
		for (int i = 0; i < this.bricks.length; i++) 
		{
			//ball collides with brick
			if ((ball.getRectangle()).intersects(bricks[i].getRectangle())) 
			{
				int ballLeft = (int) ball.getRectangle().getMinX();
				int ballHeight = (int) ball.getRectangle().getHeight();
				int ballWidth = (int) ball.getRectangle().getWidth();
				int ballTop = (int) ball.getRectangle().getMinY();

				Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
				Point pointLeft = new Point(ballLeft - 1, ballTop);
				Point pointTop = new Point(ballLeft, ballTop - 1);
				Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
				
			
				
				if (!bricks[i].isDestroyed()) 
				{
					if (bricks[i].getRectangle().contains(pointRight)) 
					{
						ball.setXDir(-1);
					}
					else if (bricks[i].getRectangle().contains(pointLeft)) 
					{
						ball.setXDir(1);
					}

					if (bricks[i].getRectangle().contains(pointTop)) 
					{
						ball.setYDir(1);
					}
					else if (bricks[i].getRectangle().contains(pointBottom)) 
					{
						ball.setYDir(-1);
					}
					
					bricks[i].setDestroyed(true);
				}
			}
		}
	}
}