package com.oosd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GameBoard extends JPanel implements Observer {
	
	public MenuButtons menuButtons;
	
	private Ball ball;
	private Paddle paddle;
	
	private int gameFlag;
	private int loadGameFlag;
	
	public GameBoard (){
		
		addKeyListener(new keyAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		this.setVisible(true);
		//this.setGameFlag(0);
		setBackground(Color.white);
	}
	
	//Key Listener for keyboard
	private class keyAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			//paddle.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			//paddle.keyPressed(e);
		}
	}
	
	
	//Function to paint game elements
	public void paint(Graphics g) {
		
		super.paint(g);
		
		paddle.draw(g);
		ball.draw(g);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	@Override
	public void update(int signal) {
		
		//repaint();
	}


	//Getters and Setters
	public Ball getBall() {
		return ball;
	}


	public void setBall(Ball ball) {
		this.ball = ball;
	}


	public Paddle getPaddle() {
		return paddle;
	}


	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}


	public int getGameFlag() {
		return gameFlag;
	}


	public void setGameFlag(int gameFlag) {
		this.gameFlag = gameFlag;
	}


	public int getLoadGameFlag() {
		return loadGameFlag;
	}


	public void setLoadGameFlag(int loadGameFlag) {
		this.loadGameFlag = loadGameFlag;
	}
}
