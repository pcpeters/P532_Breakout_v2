package com.oosd;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButtons extends JPanel implements Observer {

	private int gameState;
	private BreakoutUI breakoutUI;
	private GameBoard game;
	private GameObservable gameObservable;
	private boolean isPaused;
	private boolean isStart;
	private LayoutManager layoutType;
	private int layoutState;
	
	public JButton start_bt = new JButton("Start");
	public JButton pause_bt = new JButton("Pause");
	public JButton undo_bt = new JButton("Undo");
	public JButton replay_bt = new JButton("Replay");
	public JButton quit_bt = new JButton("Quit");
	
	public MenuButtons(final GameBoard game) {
		
		setStart(false);
		setPaused(false);
		
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		add(start_bt);
		add(pause_bt);
		add(undo_bt);
		add(replay_bt);
		add(quit_bt);
		
		pause_bt.setEnabled(false);
		undo_bt.setEnabled(false);
		replay_bt.setEnabled(false);
		
		start_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start_bt.setEnabled(true);
				undo_bt.setEnabled(true);
				replay_bt.setEnabled(false);
				game.requestFocusInWindow();
				
				if(start_bt.getText().equals("Stop")){
					
					start_bt.setText("Restart");
					pause_bt.setText("Pause");
					gameObservable.getTimer().stop();
				}
				
				
			}
			
			
		});


		
	}
	
	//Getters and Setters
	public int getGameState() {
		return gameState;
	}


	public void setGameState(int gameState) {
		this.gameState = gameState;
	}


	public BreakoutUI getBreakoutUI() {
		return breakoutUI;
	}


	public void setBreakoutUI(BreakoutUI breakoutUI) {
		this.breakoutUI = breakoutUI;
	}


	public GameBoard getGame() {
		return game;
	}


	public void setGame(GameBoard game) {
		this.game = game;
	}


	public GameObservable getGameObservable() {
		return gameObservable;
	}


	public void setGameObservable(GameObservable gameObservable) {
		this.gameObservable = gameObservable;
	}


	public boolean isPaused() {
		return isPaused;
	}


	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}


	public boolean isStart() {
		return isStart;
	}


	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}


	public LayoutManager getLayoutType() {
		return layoutType;
	}


	public void setLayoutType(LayoutManager layoutType) {
		this.layoutType = layoutType;
	}


	public int getLayoutState() {
		return layoutState;
	}


	public void setLayoutState(int layoutState) {
		this.layoutState = layoutState;
	}


	public JButton getStart_bt() {
		return start_bt;
	}


	public void setStart_bt(JButton start_bt) {
		this.start_bt = start_bt;
	}


	public JButton getPause_bt() {
		return pause_bt;
	}


	public void setPause_bt(JButton pause_bt) {
		this.pause_bt = pause_bt;
	}


	public JButton getUndo_bt() {
		return undo_bt;
	}


	public void setUndo_bt(JButton undo_bt) {
		this.undo_bt = undo_bt;
	}


	public JButton getReplay_bt() {
		return replay_bt;
	}


	public void setReplay_bt(JButton replay_bt) {
		this.replay_bt = replay_bt;
	}


	public JButton getQuit_bt() {
		return quit_bt;
	}


	public void setQuit_bt(JButton quit_bt) {
		this.quit_bt = quit_bt;
	}


	@Override
	public void update(int signal) {
		// TODO Auto-generated method stub
		
	}
	
		
}
