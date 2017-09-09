package com.oosd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.Timer;

import com.oosd.GamePlay;

import java.util.LinkedList;

public class GameObservable extends Observable {
	private GamePlay gamePlayObj;
	private Timer timer;
	private LinkedList<Object> commandHistoryList = new LinkedList<Object>();
	private LinkedList<Object> ReplayList = new LinkedList<Object>();
	private ArrayList<Object> shapeObjects;
	private boolean loadGame;
	private boolean gameFlag = true;
	private static boolean replayFlag = false;
	private int replayFrameCounter;
	private int count = 0;
	
	public boolean isGameFlag() {
		return gameFlag;
	}
	
	public boolean isLoadGame() {
		return loadGame;
	}
	
	public void setLoadGame(boolean loadGame) {
		this.loadGame = loadGame;
	}
	
	public static boolean getReplayFlag() {
		return replayFlag;
	}
	
	public static void setReplayFlag(boolean sth) {
		replayFlag = sth;
	}
	
	public LinkedList<Object> getCommandHistoryList() {
		return commandHistoryList;
	}
	
	public void setCommandHistoryList(LinkedList<Object> commandHistoryLists) {
		commandHistoryList = commandHistoryLists;
	}
	
	public LinkedList<Object> getReplayList() {
		return ReplayList;
	}
	
	public void setReplayList(LinkedList<Object> replayList) {
		ReplayList = replayList;
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

	public void setGamePlayObj(GamePlay gamePlayObj) {
		this.gamePlayObj = gamePlayObj;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public GameObservable() {
		this.gamePlayObj = new GamePlay();
		this.timer = new Timer(5, null);
		this.replayFrameCounter = 0;
	}
	
	public void pauseGame() {
		this.getTimer().stop();
	}
	
	public void resumeGame() {
		if (isLoadGame()) {
			computeAndNotify();
			String updatedTime = (String) getGamePlayObj().getListShapeObjects().get(4);
			getGamePlayObj().setCurrentMinute(Integer.parseInt(updatedTime.split(":")[0]));
			getGamePlayObj().setCurrentSecond(Integer.parseInt(updatedTime.split(":")[1]));
			
			this.getTimer().setDelay(5);
			this.getTimer().restart();
		}
	}
	
	public void computeAndNotify() {
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameFlag && !replayFlag) {
					if (count % 10 == 0) {
						commandHistoryList.add(getGamePlayObj().gameData());
					}
					ReplayList.add(getGamePlayObj().gameData());
					getGamePlayObj().performGameMovement();
					getGamePlayObj().updateDisplayClock();
					shapeObjects = getGamePlayObj().getListShapeObjects();
					setChanged();
					notifyObservers(shapeObjects);
					count++;
				}
				else {
					GameState gameStates;
					if (replayFrameCounter < ReplayList.size()) {
						gameStates = (GameState) ReplayList.get(replayFrameCounter);
						setChanged();
						shapeObjects = getGamePlayObj().getListShapeObjects();
						setChanged();
						notifyObservers(shapeObjects);
						replayFrameCounter++;
					} else {
						replayFrameCounter = 0;
						setGameFlag(true);
						timer.stop();
						getGamePlayObj().setGameFlag(2);
					}
				}
			if (getGamePlayObj().getGameFlag() == 2) {
				deleteObservers();
				timer.stop();
			}
		}
		});
		timer.setDelay(5);
		timer.restart();
		setReplayList(ReplayList);
	}

	public void undoOneStep() {
		this.timer.stop();
		if (commandHistoryList.size() != 0) {
			GameState gameStates = (GameState) this.commandHistoryList.removeLast();
			getGamePlayObj().saveDimensions(gameStates);
			ReplayList.add(gameStates);
			this.commandHistoryList.removeLast();
			shapeObjects = getGamePlayObj().getListShapeObjects();
			setChanged();
			notifyObservers(shapeObjects);
		}
	}
}
