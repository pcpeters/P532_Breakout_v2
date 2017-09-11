package com.oosd;

import org.apache.log4j.Logger;

public class ResumeCommand implements Command
{
	private GameObservable gameObservable;
	
	public static final Logger log = Logger.getLogger(ResumeCommand.class);

	/*
     * Function Name: ResumeCommand
     * Parameters In: GameObservable
     * Parameters Out: None
     * Description: Sets the game observable of the calling class object.
     */
	public ResumeCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	/*
     * Function Name: execute
     * Parameters In: None
     * Parameters Out: None
     * Description: Executing the resume command.
     */
	@Override
	public void execute()
	{
		gameObservable.resumeGame();
		log.info("Resume command");
	}
}