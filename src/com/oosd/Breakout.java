package com.oosd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

public class Breakout extends JFrame implements Constants
{	
	public static final Logger log = Logger.getLogger(Breakout.class);
	
	private static final long serialVersionUID = 1L;
	private GameBoard game;
    private MenuBoard menu;
    private MenuButtons menuButtons;
    private GameTimer clock;
    GameObservable gameObservable;

    /*
     * Function Name: Breakout
     * Parameters In: None
     * Parameters Out: None
     * Description: Instantiated object of class Breakout
     */
    public Breakout()
    {
    	log.info("Initializing the Breakout game.");
	   	game = new GameBoard();
	    menuButtons = new MenuButtons(game);
	    game.controls = menuButtons;
	    clock = new GameTimer();
	    menu = new MenuBoard(game, menuButtons, clock);
	    initUI(game, menu);
	    setMinimumSize(this.getSize());
    }
	   
    /*
     * Function Name: initUI
     * Parameters In: Object of user-defined classes GameBoard and MenuBoard
     * Parameters Out: None
     * Description: Sets the layout, adds the GameBoard,adds MenuBoard and sets title, size and other
     * 				features.
     */
	private void initUI(GameBoard game, MenuBoard menu) 
	{
		log.info("Setting the layout.");
		setLayout(new BorderLayout());
		add(game);
		add(menu, BorderLayout.SOUTH);
		pack();
		setTitle("Breakout");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
     * Function Name: main
     * Parameters In: Command line arguments
     * Parameters Out: None
     * Description: Runs the main thread of the project.
     */
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("log4j.properties");
		
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
	
	/*
     * Function Name: Getters and Setters for various member variables
     * Description: Returns the variable in case of getters and assign in case of setters
     */
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