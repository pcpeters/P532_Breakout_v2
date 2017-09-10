package com.oosd;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends GameObjects
{
    int dx;

    public Paddle(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void reset()
    {
    	x = PADDLE_X_START;
    	y = PADDLE_Y_START;
    }

    // Checks if the ball hit the paddle
    public boolean hitPaddle(int ballX, int ballY)
    {
        if ((ballX >= x) && (ballX <= x + width) && ((ballY >= y) && (ballY <= y + height))) 
        {
            return true;
        }
        return false;
    }
    
	public void move()
	{
		if (x <= 0)	//Boundary paddleleft
		{
			x = 0;
		}
		if (x >= (Constants.WINDOW_WIDTH - 10) - width) //Boundary paddle right
		{
			x = (Constants.WINDOW_WIDTH - 10) - width;
		}
		x += dx;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) 
		{
			dx = -2;
		}

		if (key == KeyEvent.VK_RIGHT) 
		{
			dx = 2;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) 
		{
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) 
		{
			dx = 0;
		}
	}

	public void resetState() 
	{
		x = (Constants.WINDOW_WIDTH / 2) - 30;
		y = 460;
	}
}