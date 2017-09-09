package com.oosd;

public class UndoCommand implements Command {
	private Object stateReceiver;
	
	public UndoCommand(Object stateReceiver) {
		if (stateReceiver instanceof GameObservable)
			this.stateReceiver = stateReceiver;
	}
	
	public void setStateReceiver(Object stateReceiver) {
		this.stateReceiver = stateReceiver;
	}
	
	public Object getStateReceiver() {
		return stateReceiver;
	}
	
	public void execute() {
		((GameObservable) stateReceiver).undoOneStep();
	}
}
