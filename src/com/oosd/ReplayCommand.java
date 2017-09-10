package com.oosd;

public class ReplayCommand implements Command
{
	private GameObservable gameObservable;
	
	/*
     * Function Name: ReplayCommand
     * Parameters In: GameObservable
     * Parameters Out: None
     * Description: Sets the game observable of the calling class object.
     */
	public ReplayCommand(GameObservable gameObservable) 
	{
			this.gameObservable = gameObservable;
	}

	/*
     * Function Name: execute
     * Parameters In: None
     * Parameters Out: None
     * Description: Executing the replay command.
     */
	@Override
	public void execute()
	{
		gameObservable.setGameFlag(false);
		gameObservable.computeAndNotify();
	}
}