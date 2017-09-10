package com.oosd;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObjects
{
    private boolean onScreen;
    private int xDir = 1, yDir = -1;

    // Constructor
    public Ball(int x, int y, int width, int height, Color color) 
    {
        super(x, y, width, height, color);
        setOnScreen(true);
    }
 
    // Draw the ball
    @Override
    public void draw(Graphics g) 
    {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }


    // Resets the ball to original position at center of screen
    public void reset() 
    {
        x = BALL_X_START;
        y = BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }

    // Getters and Setters
    public void setXDir(int xDir) 
    {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) 
    {
        this.yDir = yDir;
    }

    public void setOnScreen(boolean onScreen) 
    {
        this.onScreen = onScreen;
    }

    public int getXDir() 
    {
        return xDir;
    }

    public int getYDir() 
    {
        return yDir;
    }

    public boolean isOnScreen() 
    {
        return onScreen;
    }
    
	public void move() 
	{
		x += xDir;
		y += yDir;
		
		
		//Check collision with walls
		//Left
		if (x == 0) 
		{
			xDir = 1;
		}
		//Right
		if (x == (Constants.WINDOW_WIDTH - 22)) 
		{
			setXDir(-1);
		}
		//Top
		if (y == 0) 
		{
			yDir = 1;
		}
	}
}