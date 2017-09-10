package com.oosd;

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