package com.oosd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObjects implements Constants
{
    protected int x, y, width, height;
    protected Color color;

    public GameObjects(int x, int y, int width, int height, Color color) 
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    // Getters and Setters
    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public Color getColor() {
        return color;
    }
    
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
}