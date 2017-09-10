package com.oosd;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObjects
{
    private boolean onScreen;
    private int xDir = 1, yDir = -1;

    /*
     * Function Name: Ball
     * Parameters In: Coordinates(location), size and color of ball
     * Parameters Out: None
     * Description: Instantiated object of class Ball
     */
    public Ball(int x, int y, int width, int height, Color color) 
    {
        super(x, y, width, height, color);
        setOnScreen(true);
    }
 
    /*
     * Function Name: draw
     * Parameters In: Graphics class object
     * Parameters Out: None
     * Description: Draws the ball on the canvas
     */
    @Override
    public void draw(Graphics g) 
    {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }


    /*
     * Function Name: reset
     * Parameters In: None
     * Parameters Out: None
     * Description: Re-initializes the ball 
     */
    public void reset() 
    {
        x = BALL_X_START;
        y = BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }

    /*
     * Function Name: setXDir
     * Parameters In: y Coordinate
     * Parameters Out: None
     * Description: Sets the 'x' coordinate of the ball
     */
    public void setXDir(int xDir) 
    {
        this.xDir = xDir;
    }

    /*
     * Function Name: setYDir
     * Parameters In: y Coordinate
     * Parameters Out: None
     * Description: Sets the 'y' coordinate of the ball
     */
    public void setYDir(int yDir) 
    {
        this.yDir = yDir;
    }

    /*
     * Function Name: setOnScreen
     * Parameters In: boolean
     * Parameters Out: None
     * Description: Toggles the on screen position of the ball
     */
    public void setOnScreen(boolean onScreen) 
    {
        this.onScreen = onScreen;
    }
    
    /*
     * Function Name: getXDir
     * Parameters In: None
     * Parameters Out: 'x' coordinate of the ball
     * Description: Returns the 'x' coordinate of the ball
     */
    public int getXDir() 
    {
        return xDir;
    }

    /*
     * Function Name: getYDir
     * Parameters In: None
     * Parameters Out: 'y' coordinate of the ball
     * Description: Sets the 'y' coordinate of the ball
     */
    public int getYDir() 
    {
        return yDir;
    }

    /*
     * Function Name: isOnScreen
     * Parameters In: None
     * Parameters Out: boolean
     * Description: Return 'onScreen'
     */
    public boolean isOnScreen() 
    {
        return onScreen;
    }
    
    /*
     * Function Name: move
     * Parameters In: None
     * Parameters Out: None
     * Description: Logic to move the ball as well as checks the collision with the wall
     */
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