package com.oosd;

import java.util.ArrayList;

public class GameState {
	
	private int ballX;
	private int ballY;
	private int ballXDir;
	private int ballYDir;
	private int paddleX;
	private int paddleY;
	private ArrayList<Boolean> isBrickDestroyed;
	private int gameFlag;
	private String setTimeForDisplayClock;
	private int layoutState;
	
	
	public GameState (int ballX, int ballY, int ballXDir, int ballYDir, int paddleX, int paddleY,
			int gameFlag, String timeForDisplayClock,
			ArrayList<Boolean> isBrickDestroyed, int layoutState)
	{
		this.ballX = ballX;
		this.ballY = ballY;
		this.ballXDir = ballXDir;
		this.ballYDir = ballYDir;
		this.paddleX = paddleX;
		this.paddleY = paddleY;
		this.isBrickDestroyed = isBrickDestroyed;
		setGameFlag(gameFlag);
		setSetTimeForDisplayClock(timeForDisplayClock);
		setLayoutState(layoutState);
	}
	
	//Getters and Setters
	
	public int getBallX() {
		return ballX;
	}
	
	public void setBallX(int ballX) {
		this.ballX = ballX;
	}
	
	public int getBallY() {
		return ballY;
	}
	
	public void setBallY(int ballY) {
		this.ballY = ballY;
	}
	
	public int getBallXDir() {
		return ballXDir;
	}
	
	public void setBallXDir(int ballXDir) {
		this.ballXDir = ballXDir;
	}
	
	public int getBallYDir() {
		return ballYDir;
	}
	
	public void setBallYDir(int ballYDir) {
		this.ballYDir = ballYDir;
	}
	
	public int getPaddleX() {
		return paddleX;
	}
	
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}
	
	public int getPaddleY() {
		return paddleY;
	}
	
	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}
	
	public ArrayList<Boolean> getIsBrickDestroyed() {
		return isBrickDestroyed;
	}
	
	public void setIsBrickDestroyed(ArrayList<Boolean> isBrickDestroyed) {
		this.isBrickDestroyed = isBrickDestroyed;
	}
	
	public int getGameFlag() {
		return gameFlag;
	}
	
	public void setGameFlag(int gameFlag) {
		this.gameFlag = gameFlag;
	}
	
	public String getSetTimeForDisplayClock() {
		return setTimeForDisplayClock;
	}
	
	public void setSetTimeForDisplayClock(String setTimeForDisplayClock) {
		this.setTimeForDisplayClock = setTimeForDisplayClock;
	}
	
	public int getLayoutState() {
		return layoutState;
	}
	
	public void setLayoutState(int layoutState) {
		this.layoutState = layoutState;
	}

}
