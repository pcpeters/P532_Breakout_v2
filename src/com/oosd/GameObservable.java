package com.oosd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Timer;

import java.util.LinkedList;

//Observable class that notifies observers to update state

public class GameObservable extends Observable
{
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

	public boolean isLoadGame()
	{
		return loadGame;
	}

	public void setLoadGame(boolean loadGame)
	{
		this.loadGame = loadGame;
	}
	
	public static boolean getReplayFlag()
	{
		return replayFlag;
	}
	
	public static void setReplayFlag(boolean value)
	{
		replayFlag = value;
	}

	public LinkedList<Object> getCommandHistoryList()
	{
		return CommandHistoryList;
	}

	public void setCommandHistoryList(LinkedList<Object> commandHistoryList)
	{
		CommandHistoryList = commandHistoryList;
	}

	public LinkedList<Object> getReplayList()
	{
		return ReplayList;
	}

	public void setReplayList(LinkedList<Object> replayList)
	{
		ReplayList = replayList;
	}

	public boolean isGameFlag()
	{
		return gameFlag;
	}

	public void setGameFlag(boolean gameFlag)
	{
		this.gameFlag = gameFlag;
	}

	public ArrayList<Object> getShapeObjects()
	{
		return shapeObjects;
	}

	public void setShapeObjects(ArrayList<Object> shapeObjects)
	{
		this.shapeObjects = shapeObjects;
	}

	public GamePlay getGamePlayObj()
	{
		return gamePlayObj;
	}

	public void setGamePlayObj(GamePlay computeCoordinatesObj) 
	{
		this.gamePlayObj = computeCoordinatesObj;
	}

	public Timer getTimer()
	{
		return timer;
	}

	public void setTimer(Timer timer)
	{
		this.timer = timer;
	}

	public GameObservable()
	{
		this.gamePlayObj = new GamePlay();
		this.timer = new Timer(5, null);
		this.replayFrameCounter = 0;
	}

	//Notify observer
	public void computeAndNotify()
	{
		timer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (gameFlag && !replayFlag)
				{
					//System.out.println("Game running..");
					if (count % 10 == 0)
					{
						CommandHistoryList.add(getGamePlayObj().getGameStateList());
					}
					ReplayList.add(getGamePlayObj().getGameStateList());
					getGamePlayObj().moveGameObjects();
					getGamePlayObj().updateGameTimer();
					shapeObjects = getGamePlayObj().getGameObjectList();
					setChanged();
					notifyObservers(shapeObjects);
					count++;
				} 
				else
				{
					//System.out.println("Replay..");
					
					GameState storeDimensions;
					if (replayFrameCounter < ReplayList.size())
					{
						storeDimensions = (GameState) ReplayList.get(replayFrameCounter);
						getGamePlayObj().saveGameState(storeDimensions);
						setChanged();
						shapeObjects = getGamePlayObj().getGameObjectList();
						setChanged();
						notifyObservers(shapeObjects);
						replayFrameCounter++;
					} 
					else
					{
						//System.out.println("Replay over");
						replayFrameCounter = 0;
						setGameFlag(true);
						timer.stop();
						getGamePlayObj().setGameFlag(2);
					}
				}

				if (getGamePlayObj().getGameFlag() == 2)
				{
					//System.out.println("Game Over");
					deleteObservers();
					timer.stop();
				}
			}
		});
		timer.setDelay(5);
		timer.restart();
		setReplayList(ReplayList);
	}

	//Removes last object from list for undo
	public void undoTesting()
	{
		this.timer.stop();
		if (CommandHistoryList.size() != 0)
		{
			GameState storeDimensions = (GameState) this.CommandHistoryList.removeLast();
			getGamePlayObj().saveGameState(storeDimensions);
			ReplayList.add(storeDimensions);
			this.CommandHistoryList.removeLast();
			shapeObjects = getGamePlayObj().getGameObjectList();
			setChanged();
			notifyObservers(shapeObjects);
		}
	}

	public void pauseGame()
	{
		this.getTimer().stop();
	}

	public void resumeGame()
	{
		if (isLoadGame())
		{
			computeAndNotify();
		}
		
		String updatedTime = (String) getGamePlayObj().getGameObjectList().get(4);
		getGamePlayObj().setCurrentMinute(Integer.parseInt(updatedTime.split(":")[0]));
		getGamePlayObj().setCurrentSecond(Integer.parseInt(updatedTime.split(":")[1]));
		
		this.getTimer().setDelay(5);
		this.getTimer().restart();
	}
}