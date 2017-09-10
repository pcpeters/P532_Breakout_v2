package com.oosd;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObjects implements Constants 
{
    private int hits;
    private boolean destroyed;

    /*
     * Function Name: Brick
     * Parameters In: Location, size and color of brick
     * Parameters Out: None
     * Description: Constructor to instantiate the Brick object.
     */
	public Brick(int x, int y, int width, int height, Color color) 
	{
		super(x, y, width, height, color);
		setHits(0);
		setDestroyed(false);
	}

	/*
     * Function Name: draw
     * Parameters In: Graphics
     * Parameters Out: None
     * Description: Draws the brick on the canvas.
     */
    @Override
    public void draw(Graphics g) 
    {
        if (!destroyed) 
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    /*
     * Function Name: addHit
     * Parameters In: None
     * Parameters Out: None
     * Description: Stores the state of brick (hit or not)
     */
    public void addHit() 
    {
        setDestroyed(true);
    }

    /*
     * Function Name: hitBottom
     * Parameters In: Coordinates of ball
     * Parameters Out: None
     * Description: Check the collision of ball and brick bottom
     */
    public boolean hitBottom(int ballX, int ballY) 
    {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y + height) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    /*
     * Function Name: hitBottom
     * Parameters In: Coordinates of ball
     * Parameters Out: None
     * Description: Check the collision of ball and brick top
     */
    public boolean hitTop(int ballX, int ballY) 
    {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    /*
     * Function Name: hitBottom
     * Parameters In: Coordinates of ball
     * Parameters Out: None
     * Description: Check the collision of ball and brick left side
     */
    public boolean hitLeft(int ballX, int ballY) 
    {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    /*
     * Function Name: hitBottom
     * Parameters In: Coordinates of ball
     * Parameters Out: None
     * Description: Check the collision of ball and brick right side
     */
    public boolean hitRight(int ballX, int ballY) 
    {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x + width) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    /*
     * Description: Getters and Setters
     * Parameters In: Only in case of setters
     * Parameters Out: Only in case of getters
     */
    public void setHits(int hits) 
    {
        this.hits = hits;
    }

    public void setDestroyed(boolean destroyed) 
    {
        this.destroyed = destroyed;
    }

    public int getHits() 
    {
        return hits;
    }

    public boolean isDestroyed() 
    {
        return destroyed;
    }
}