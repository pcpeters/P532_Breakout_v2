package com.oosd;

public class StartCommand implements Command
{
	private GameObservable gameObservable;

	/*
     * Function Name: StartCommand
     * Parameters In: GameObservable
     * Parameters Out: None
     * Description: Sets the game observable of the calling class object.
     */
	public StartCommand(GameObservable gameObservable) 
	{
			this.gameObservable = gameObservable;
	}

	/*
     * Function Name: execute
     * Parameters In: None
     * Parameters Out: None
     * Description: Executing the start command.
     */
	@Override
	public void execute()
	{
		gameObservable.setGameFlag(true);
		gameObservable.computeAndNotify();
	}
}