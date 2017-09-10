package com.oosd;

/**
 * ResumeCommnad Class
 * 
 * This class acts as the command object for the resume button on the UI. It
 * initializes the receiver or listener of its command event.
 * 
 * execute() - It resumes the game from pause state.
 * 
 */

public class ResumeCommand implements Command
{
	private GameObservable gameObservable;

	public ResumeCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	@Override
	public void execute()
	{
		gameObservable.resumeGame();
	}
}