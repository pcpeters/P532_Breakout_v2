package com.oosd;

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