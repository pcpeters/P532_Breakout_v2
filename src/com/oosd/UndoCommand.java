package com.oosd;

public class UndoCommand implements Command
{
	private GameObservable gameObservable;

	public UndoCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	@Override
	public void execute()
	{
		gameObservable.undoTesting();
	}
}