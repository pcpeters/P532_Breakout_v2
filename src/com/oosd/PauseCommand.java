package com.oosd;

import org.apache.log4j.Logger;

public class PauseCommand implements Command
{
	private GameObservable gameObservable;
	
	public static final Logger log = Logger.getLogger(PauseCommand.class);

	/*
     * Function Name: PauseCommand
     * Parameters In: GameObservable
     * Parameters Out: None
     * Description: Sets the game observable of the calling class object.
     */
	public PauseCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	/*
     * Function Name: execute
     * Parameters In: None
     * Parameters Out: None
     * Description: Executing the pause command.
     */
	@Override
	public void execute()
	{
		gameObservable.pauseGame();
		log.info("Pause command");
	}
}