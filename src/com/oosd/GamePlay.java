package com.oosd;

import java.awt.Color;
import java.util.ArrayList;


public class GamePlay {
	
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	
	private int gameFlag;
	
	private int currentSecond, currentMinute;
	private String timeForDisplayClock;
	
	private int timerTracker = 0;
	private int layoutState = 0;
	
	public GamePlay() {
		
		this.ball = new Ball(Constants.BALL_X_START, Constants.BALL_Y_START, Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Color.BLACK);
		this.paddle = new Paddle(Constants.PADDLE_X_START, Constants.PADDLE_Y_START, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.BLACK);
		this.setGameFlag(1);
		makeBricks();
	}
	
	//Initialise bricks
	private void makeBricks(){
		
	}
	
	public ArrayList<Object> getListShapeObjects(){
		
		ArrayList<Object> objectList = new ArrayList<Object>();
		
		objectList.add(Integer.valueOf(this.getGameFlag()));
		objectList.add(this.getBall());
		objectList.add(this.getBricks());
		objectList.add(this.getPaddle());
		objectList.add(this.timeForDisplayClock);
		objectList.add(this.getLayoutState());
		return objectList;		
	}
	
	public ArrayList<Boolean> getBrickFlags() {
		
		ArrayList<Boolean> brickFlags = new ArrayList<Boolean>();
		
		for(int i=0; i < Constants.MAX_BRICKS; i++){
			brickFlags.add(i, this.bricks[i].isDestroyed());
		}
		return brickFlags;
	}
	
	public void saveGameState(GameState objList) {
		
		getBall().setX(objList.getBallX());
		getBall().setY(objList.getBallY());
		getBall().setxDir(objList.getBallXDir());
		getBall().setyDir(objList.getBallYDir());
		getPaddle().setY(objList.getPaddleY());
		getPaddle().setX(objList.getPaddleX());
		setGameFlag(objList.getGameFlag());
		setTimeForDisplayClock(objList.getSetTimeForDisplayClock());
		setLayoutState(objList.getLayoutState());
		
		ArrayList<Boolean> getBrickFlags = objList.getIsBrickDestroyed();
		
		for(int i=0; i < Constants.MAX_BRICKS; i++){
			
			//
		}
		
	}
	
	public void moveGameObjects() {
		
		if(this.getGameFlag() == 1) {
			this.ball.move();
			this.paddle.move();
			checkCollision();
		}
	}
	
	//Increment minute value of clock
	private void refresh() 
	{
		currentMinute++;
		currentSecond = 0;
	}

	public void start() 
	{
		currentMinute++;
	}
	
	//Reset the clock
	public void reset() 
	{
		currentMinute = -1;
		currentSecond = 0;
		timeForDisplayClock = "00:00";
		timerTracker = 0;
	}
	
	public String updateDisplayClock() 
	{
		timerTracker++;
		if (timerTracker >= 100) 
		{
			if (currentSecond == 60) 
			{
				refresh();
			}
			timeForDisplayClock = String.format("%02d:%02d", currentMinute, currentSecond);
			currentSecond++;
			timerTracker = 0;
		}
		return timeForDisplayClock;
	}
	
	public void checkCollision() {
		
		//ball collides with bottom
		
		//ball collides with paddle
		
		//brick collision
	}
	
	//Getters and Setters
	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}

	public int getGameFlag() {
		return gameFlag;
	}

	public void setGameFlag(int gameFlag) {
		this.gameFlag = gameFlag;
	}

	public int getCurrentSecond() {
		return currentSecond;
	}

	public void setCurrentSecond(int currentSecond) {
		this.currentSecond = currentSecond;
	}

	public int getCurrentMinutes() {
		return currentMinute;
	}

	public void setCurrentMinutes(int currentMinutes) {
		this.currentMinute = currentMinutes;
	}

	public String getTimeForDisplayClock() {
		return timeForDisplayClock;
	}

	public void setTimeForDisplayClock(String timeForDisplayClock) {
		this.timeForDisplayClock = timeForDisplayClock;
	}

	public int getTimeTracker() {
		return timerTracker;
	}

	public void setTimeTracker(int timeTracker) {
		this.timerTracker = timeTracker;
	}

	public int getLayoutState() {
		return layoutState;
	}

	public void setLayoutState(int layoutState) {
		this.layoutState = layoutState;
	}

}
