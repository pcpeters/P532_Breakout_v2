package com.oosd;

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