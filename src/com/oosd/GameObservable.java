package com.oosd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.Timer;

public class GameObservable extends Observable {
	private GamePlay gamePlayObj;
	private Timer timer;

	private boolean loadGame;
	private boolean gameFlag = true;

	private static boolean replayFlag = false;
	private int replayFrameCounter;
	private int count = 0;

	private LinkedList<Object> CommandHistoryList = new LinkedList<Object>();
	private LinkedList<Object> ReplayList = new LinkedList<Object>();
	private ArrayList<Object> shapeObjects;

	/*
	 * Parameters In: Only in case of setters Parameters Out: Only in case of
	 * getters Description: Getters and Setters for class members.
	 */

	public boolean isLoadGame() {
		return loadGame;
	}

	public void setLoadGame(boolean loadGame) {
		this.loadGame = loadGame;
	}

	public static boolean getReplayFlag() {
		return replayFlag;
	}

	public static void setReplayFlag(boolean value) {
		replayFlag = value;
	}

	public LinkedList<Object> getCommandHistoryList() {
		return CommandHistoryList;
	}

	public void setCommandHistoryList(LinkedList<Object> commandHistoryList) {
		CommandHistoryList = commandHistoryList;
	}

	public LinkedList<Object> getReplayList() {
		return ReplayList;
	}

	public void setReplayList(LinkedList<Object> replayList) {
		ReplayList = replayList;
	}

	public boolean isGameFlag() {
		return gameFlag;
	}

	public void setGameFlag(boolean gameFlag) {
		this.gameFlag = gameFlag;
	}

	public ArrayList<Object> getShapeObjects() {
		return shapeObjects;
	}

	public void setShapeObjects(ArrayList<Object> shapeObjects) {
		this.shapeObjects = shapeObjects;
	}

	public GamePlay getGamePlayObj() {
		return gamePlayObj;
	}

	public void setGamePlayObj(GamePlay computeCoordinatesObj) {
		gamePlayObj = computeCoordinatesObj;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/*
	 * Function Name: GameObservable Parameters In: None Parameters Out: None
	 * Description: Initializes the GameObservable object.
	 */

	public GameObservable() {
		gamePlayObj = new GamePlay();
		timer = new Timer(5, null);
		replayFrameCounter = 0;
	}

	/*
	 * Function Name: computeAndNotify Parameters In: None Parameters Out: None
	 * Description: Notifies the observer.
	 */
	public void computeAndNotify() {
		timer.addActionListener(e -> {
			if (gameFlag && !replayFlag) {
				// System.out.println("Game running..");
				if (count % 10 == 0) {
					CommandHistoryList.add(getGamePlayObj().getGameStateList());
				}
				ReplayList.add(getGamePlayObj().getGameStateList());
				getGamePlayObj().moveGameObjects();
				getGamePlayObj().updateGameTimer();
				shapeObjects = getGamePlayObj().getGameObjectList();
				setChanged();
				notifyObservers(shapeObjects);
				count++;
			} else {
				// System.out.println("Replay..");

				GameState storeDimensions;
				if (replayFrameCounter < ReplayList.size()) {
					storeDimensions = (GameState) ReplayList.get(replayFrameCounter);
					getGamePlayObj().saveGameState(storeDimensions);
					setChanged();
					shapeObjects = getGamePlayObj().getGameObjectList();
					setChanged();
					notifyObservers(shapeObjects);
					replayFrameCounter++;
				} else {
					// System.out.println("Replay over");
					replayFrameCounter = 0;
					setGameFlag(true);
					timer.stop();
					getGamePlayObj().setGameFlag(2);
				}
			}

			if (getGamePlayObj().getGameFlag() == 2) {
				// System.out.println("Game Over");
				deleteObservers();
				timer.stop();
			}
		});
		timer.setDelay(5);
		timer.restart();
		setReplayList(ReplayList);
	}

	/*
	 * Function Name: undoOneStep Parameters In: None Parameters Out: None
	 * Description: Removes last object from list for undo.
	 */
	public void undoOneStep() {
		timer.stop();
		if (CommandHistoryList.size() != 0) {
			final GameState lastGameState = (GameState) CommandHistoryList.removeLast();
			getGamePlayObj().saveGameState(lastGameState);
			ReplayList.add(lastGameState);
			CommandHistoryList.removeLast();
			shapeObjects = getGamePlayObj().getGameObjectList();
			setChanged();
			notifyObservers(shapeObjects);
		}
	}

	/*
	 * Function Name: pauseGame Parameters In: None Parameters Out: None
	 * Description: Stops the timer of the corresponding timer.
	 */
	public void pauseGame() {
		getTimer().stop();
	}

	/*
	 * Function Name: resumeGame Parameters In: None Parameters Out: None
	 * Description: Sets the time and notifies the observer.
	 */

	public void resumeGame() {
		if (isLoadGame()) {
			computeAndNotify();
		}

		final String updatedTime = (String) getGamePlayObj().getGameObjectList().get(4);
		getGamePlayObj().setCurrentMinute(Integer.parseInt(updatedTime.split(":")[0]));
		getGamePlayObj().setCurrentSecond(Integer.parseInt(updatedTime.split(":")[1]));

		getTimer().setDelay(5);
		getTimer().restart();
	}
}