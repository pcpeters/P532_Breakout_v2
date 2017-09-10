package com.oosd;

import java.util.ArrayList;

/**
 * GameData class
 * 
 * Sprite data i.e. the x and y coordinates of ball and paddle and bricks
 *
 */

public class GameObjectCoordinates 
{
	private int gameFlag;
	private int ballX;
	private int ballY;
	private int paddleX;
	private int paddleY;
	private ArrayList<Boolean> isBrickDestroyed;

	
	//Getters and Setters
	
	public int getBallX()
	{
		return ballX;
	}

	public void setBallX(int ballX)
	{
		this.ballX = ballX;
	}

	public int getBallY()
	{
		return ballY;
	}
	
	public void setBallY(int ballY)
	{
		this.ballY = ballY;
	}
	
	public int getPaddleX()
	{
		return paddleX;
	}
	
	public void setPaddleX(int paddleX)
	{
		this.paddleX = paddleX;
	}
	
	public int getPaddleY()
	{
		return paddleY;
	}
	
	public void setPaddleY(int paddleY)
	{
		this.paddleY = paddleY;
	}
	
	public ArrayList<Boolean> isBrickDestroyed()
	{
		return isBrickDestroyed;
	}
	
	public void setBrickDestroyed(ArrayList<Boolean> brickList)
	{
		this.isBrickDestroyed = brickList;
	}

	public int getGameFlag()
	{
		return gameFlag;
	}
	
	public void setGameFlag(int gameFlag)
	{
		this.gameFlag = gameFlag;
	}
}