package com.oosd;

/**
 * ReplayCommand Class
 * 
 * This class acts as the command object for the replay button on the UI.
 * It initializes the receiver or listener of its command event.
 * 
 * execute() - It executes the replay command.	  
 * 
 */

public class ReplayCommand implements Command
{
	private GameObservable gameObservable;
	
	public ReplayCommand(GameObservable gameObservable) 
	{
			this.gameObservable = gameObservable;
	}

	@Override
	public void execute()
	{
		gameObservable.setGameFlag(false);
		gameObservable.computeAndNotify();
	}
}