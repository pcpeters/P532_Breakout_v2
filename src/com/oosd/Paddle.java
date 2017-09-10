package com.oosd;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends GameObjects
{
    int dx;
    /*
     * Function Name: Paddle
     * Parameters In: Location, size and color of brick
     * Parameters Out: None
     * Description: Initializes a brick with provided configuration.
     */
    public Paddle(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    /*
     * Function Name: draw
     * Parameters In: Graphics
     * Parameters Out: None
     * Description: Draws the brick on the board.
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /*
     * Function Name: reset
     * Parameters In: None
     * Parameters Out: None
     * Description: Resets the paddle position.
     */
    public void reset()
    {
    	x = PADDLE_X_START;
    	y = PADDLE_Y_START;
    }

    /*
     * Function Name: hitPaddle
     * Parameters In: Ball Coordinates
     * Parameters Out: boolean
     * Description: Checks if the ball hit the paddle.
     */
    public boolean hitPaddle(int ballX, int ballY)
    {
        if ((ballX >= x) && (ballX <= x + width) && ((ballY >= y) && (ballY <= y + height))) 
        {
            return true;
        }
        return false;
    }
    
    /*
     * Function Name: move
     * Parameters In: None
     * Parameters Out: None
     * Description: Logic to move the paddle.
     */
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

	/*
     * Function Name: keyPressed
     * Parameters In: KeyEvent
     * Parameters Out: None
     * Description: Captures the key events and accordingly moves the paddle.
     */
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

	/*
     * Function Name: resetState
     * Parameters In: None
     * Parameters Out: None
     * Description: Reset the state of the canvas.
     */
	public void resetState() 
	{
		x = (Constants.WINDOW_WIDTH / 2) - 30;
		y = 460;
	}
}