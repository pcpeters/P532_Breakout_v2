package com.oosd;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObjects implements Constants 
{
    private int hits;
    private boolean destroyed;

	public Brick(int x, int y, int width, int height, Color color) 
	{
		super(x, y, width, height, color);
		setHits(0);
		setDestroyed(false);
	}

    @Override
    public void draw(Graphics g) 
    {
        if (!destroyed) 
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    //Destroy brick
    public void addHit() 
    {
        setDestroyed(true);
    }

    //Brick collision
    public boolean hitBottom(int ballX, int ballY) 
    {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y + height) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitTop(int ballX, int ballY) 
    {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitLeft(int ballX, int ballY) 
    {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitRight(int ballX, int ballY) 
    {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x + width) && (destroyed == false)) 
        {
            addHit();
            return true;
        }
        return false;
    }

    //Getters and Setters
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