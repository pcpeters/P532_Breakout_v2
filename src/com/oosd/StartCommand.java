package com.oosd;

/**
 * StartCommand Class
 * 
 * This class acts as the command object for the start button on the UI. It
 * initializes the receiver or listener of its command event.
 * 
 * execute() - It executes the start game command.
 * 
 */

public class StartCommand implements Command
{
	private GameObservable gameObservable;

	public StartCommand(GameObservable gameObservable) 
	{
			this.gameObservable = gameObservable;
	}

	@Override
	public void execute()
	{
		gameObservable.setGameFlag(true);
		gameObservable.computeAndNotify();
	}
}