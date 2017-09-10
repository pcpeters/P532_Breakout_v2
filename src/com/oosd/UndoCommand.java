package com.oosd;

public class UndoCommand implements Command
{
	private GameObservable gameObservable;

	/*
     * Function Name: UndoCommand
     * Parameters In: GameObservable
     * Parameters Out: None
     * Description: Sets the game observable of the calling class object.
     */
	public UndoCommand(GameObservable gameObservable)
	{
			this.gameObservable = gameObservable;
	}

	
	/*
     * Function Name: execute
     * Parameters In: None
     * Parameters Out: None
     * Description: Executing the undo command.
     */
	@Override
	public void execute()
	{
		gameObservable.undoTesting();
	}
}