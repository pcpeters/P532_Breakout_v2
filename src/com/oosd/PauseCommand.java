package com.oosd;

public class PauseCommand implements Command
{
	private GameObservable gameObservable;

	public PauseCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	@Override
	public void execute()
	{
		gameObservable.pauseGame();
	}
}