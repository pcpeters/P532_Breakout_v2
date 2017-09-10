package com.oosd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Breakout extends JFrame implements Constants
{	
	private static final long serialVersionUID = 1L;
	private GameBoard game;
    private MenuBoard menu;
    private MenuButtons menuButtons;
    private GameTimer clock;
    GameObservable gameObservable;

    public Breakout()
    {
	   	game = new GameBoard();
	    menuButtons = new MenuButtons(game);
	    game.controls = menuButtons;
	    clock = new GameTimer();
	    menu = new MenuBoard(game, menuButtons, clock);
	    initUI(game, menu);
	    setMinimumSize(this.getSize());
    }
	    
	private void initUI(GameBoard game, MenuBoard menu) 
	{
		setLayout(new BorderLayout());
		add(game);
		add(menu, BorderLayout.SOUTH);
		pack();
		setTitle("Breakout");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
		@Override
		public void run()
		{
			Breakout gameDriver = new Breakout();           
	        gameDriver.setVisible(true);
	        gameDriver.getControlButtons().setGameDriver(gameDriver);
	        gameDriver.getControlButtons().setClock(gameDriver.getDisplayClock());
	        gameDriver.getControlButtons().setGame(gameDriver.getGameBoard());
			}
	    });
	}
	
	//Getters and Setters
	
	public GameObservable getTimerObs()
	{
		return gameObservable;
	}

	public void setTimerObs(GameObservable gameObservable)
	{
		this.gameObservable = gameObservable;
	}

	public GameBoard getGameBoard()
	{
	   	return game;
	}
	
	public void setGame(GameBoard game)
	{
		this.game = game;
	}

	public void setClock(GameTimer clock)
	{
		this.clock = clock;
	}

	public MenuBoard getMenuBoard()
	{
	   	return menu;
	}
	
	public MenuButtons getControlButtons()
	{
	  	return menuButtons;
	}
	
	public GameTimer getDisplayClock()
	{
	   	return clock;
	}
}