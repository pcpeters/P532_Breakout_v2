package com.oosd;

import javax.swing.Timer;

public class GameObservable {
	
	
	private GamePlay gamePlay;
	private Timer timer;
	
	boolean loadGame;
	private boolean gameFlag = true;
	
	public void GameObservable(){
		
		this.gamePlay = new GamePlay();
		this.timer = new Timer(5, null);
		
	}
	
	public void notifyObserver() {
		
		timer.addActionListener(new ActionListener( {
			
			if(gameFlag && !replayFlag){

				
			}
				
		}));
	}
	
	
	//Getters and Setters
	public GamePlay getGamePlay() {
		return gamePlay;
	}
	public void setGamePlay(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}
	
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public boolean isLoadGame() {
		return loadGame;
	}
	public void setLoadGame(boolean loadGame) {
		this.loadGame = loadGame;
	}
	public boolean isGameFlag() {
		return gameFlag;
	}
	public void setGameFlag(boolean gameFlag) {
		this.gameFlag = gameFlag;
	}
	
	
}
