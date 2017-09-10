package com.oosd;

/**
 * UndoCommand Class
 * 
 * This class acts as the command object for the undo button on the UI. It
 * initializes the receiver or listener of its command event.
 * 
 * execute() - it executes the undo functionality of the game.
 * 
 */

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