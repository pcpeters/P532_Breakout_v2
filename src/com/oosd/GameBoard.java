package com.oosd;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameBoard extends JPanel implements Constants, Observer
{
	public MenuButtons controls;
	private String message;		//Game screen message
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	private int gameFlag;		// 0 - game init, 1 - game start, 2 - game over
	private int loadGameFlag;	//True is game loaded
	LinkedList<Object> listFromFile;

	public GameBoard()
	{
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		this.setVisible(true);
		this.setGameFlag(0);
		setBackground(Color.white);
	}

	public int getLoadGameFlag()
	{
		return loadGameFlag;
	}

	public void setLoadGameFlag(int loadGameFlag)
	{
		this.loadGameFlag = loadGameFlag;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	public Ball getBall() 
	{
		return ball;
	}

	public void setBall(Ball ball) 
	{
		this.ball = ball;
	}

	public Paddle getPaddle() 
	{
		return paddle;
	}

	public void setPaddle(Paddle paddle) 
	{
		this.paddle = paddle;
	}

	public Brick[] getBricks() 
	{
		return bricks;
	}

	public void setBricks(Brick[] bricks)
	{
		this.bricks = bricks;
	}

	public int getGameFlag()
	{
		return gameFlag;
	}

	public void setGameFlag(int gameFlag)
	{
		this.gameFlag = gameFlag;
	}

	private class TAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			paddle.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			paddle.keyPressed(e);
		}
	}

	public void paint(Graphics graphics)
	{
		super.paint(graphics);
		if (this.getLoadGameFlag() == 3 && this.getGameFlag() != 2)
		{
			//System.out.println("1..........");
			paddle.draw(graphics);
			ball.draw(graphics);

			for (int i = 0; i < this.bricks.length; i++)
			{
				if (!bricks[i].isDestroyed())
				{
					bricks[i].draw(graphics);
				}
			}
		} 
		
		else if (this.getGameFlag() == 1)
		{
			//System.out.println("Game Running..");
			paddle.draw(graphics);
			ball.draw(graphics);

			for (int i = 0; i < this.bricks.length; i++)
			{
				if (!bricks[i].isDestroyed())
				{
					bricks[i].draw(graphics);
				}
			}
		} 
		else 
		{
			//System.out.println("Print Message");
			Font font = new Font("Times New Roman", Font.BOLD, 30);
			FontMetrics metr = this.getFontMetrics(font);

			if (this.getGameFlag() == 0)
			{
				System.out.println("Start Game..");
				setMessage("Start Game");
			} 
			else if (!this.getMessage().equalsIgnoreCase("Victory") && this.getGameFlag() == 2)
			{
				//Game over
				controls.start_bt.setText("Restart");
				controls.replay_bt.setEnabled(true);
				controls.pause_bt.setEnabled(false);
				controls.undo_bt.setEnabled(false);
				setMessage("Game Over");
			}
			graphics.setColor(Color.BLACK);
			graphics.setFont(font);
			graphics.drawString(
					message,
					(Constants.WINDOW_WIDTH - metr.stringWidth(this.getMessage())) / 2,
					Constants.WINDOW_WIDTH  / 2);
		}
		Toolkit.getDefaultToolkit().sync();
		graphics.dispose();
	}

	
	//List of game objects to be painted
	private void unpackShapeList(ArrayList<Object> gameObjectList)
	{
		//List contains flag, ball, bricks, paddle
		if (gameObjectList.get(0) instanceof Number)
		{
			int flag = (Integer) gameObjectList.get(0);
			setGameFlag(flag);
		}
		if (gameObjectList.get(1) instanceof Ball)
		{
			setBall((Ball) gameObjectList.get(1));
		}
		if (gameObjectList.get(2) instanceof Brick[])
		{
			setBricks((Brick[]) gameObjectList.get(2));
		}
		if (gameObjectList.get(3) instanceof Paddle)
		{
			setPaddle((Paddle) gameObjectList.get(3));
		}
	}
	
	//Update notification for observer
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable observable, Object objectList)
	{
		unpackShapeList((ArrayList<Object>) objectList);
		repaint();
	}
}