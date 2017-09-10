package com.oosd;

/**
 * PauseCommand Class
 * 
 * This class acts as the command object for the pause button on the UI. It
 * initializes the receiver or listener of its command event.
 * 
 * execute() - Its executes the pause functionality.
 * 
 */

public class PauseCommand implements Command
{
	private GameObservable gameObservable;

	public PauseCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	/*
	 * Method - it executes the pause functionality for the pause command.
	 */
	@Override
	public void execute()
	{
		gameObservable.pauseGame();
	}
}