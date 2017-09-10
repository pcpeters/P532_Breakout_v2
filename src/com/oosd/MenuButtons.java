package com.oosd;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class ControlButtons - It acts as the panel for all the buttons and has all
 * the action listeners of the buttons.
 * 
 *
 */

public class MenuButtons extends JPanel implements Observer 
{
	private static final long serialVersionUID = 1L;
	
	private Command command;	
	private GameObservable gameObservable;
	private Breakout breakout;
	private GameBoard game;
	private GameTimer clock;
	
	private boolean isPaused;
	private boolean isStart;
	
	private int layoutState;
	private int gameState;

	public JButton start_bt = new JButton("Start");
	public JButton pause_bt = new JButton("Pause");
	public JButton undo_bt = new JButton("Undo");
	public JButton replay_bt = new JButton("Replay");
	public JButton quit_bt = new JButton("Quit");

	
	public MenuButtons(final GameBoard game) 
	{
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
		
		start_bt.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				pause_bt.setEnabled(true);
				undo_bt.setEnabled(true);
				replay_bt.setEnabled(false);
				game.requestFocusInWindow();

				if (start_bt.getText().equals("Stop")) 
				{
					start_bt.setText("Restart");
					pause_bt.setText("Pause");
					gameObservable.getTimer().stop();
					pause_bt.setEnabled(false);
					undo_bt.setEnabled(false);
					replay_bt.setEnabled(true);
				}

				else if (start_bt.getText().equals("Start") || start_bt.getText().equals("Restart")) 
				{
					StartCommand startCmd;
					
					gameObservable = new GameObservable();
					gameObservable.addObserver((Observer) breakout.getGameBoard());
					gameObservable.addObserver((Observer) breakout.getDisplayClock());
					gameObservable.deleteObserver((Observer) breakout.getControlButtons());
					
					startCmd = new StartCommand(gameObservable);
					
					setCommand(startCmd);
					press();
					start_bt.setText("Stop");
				}
			}
		});

		pause_bt.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				start_bt.setEnabled(true);
				game.requestFocusInWindow();
				if (pause_bt.getText().equals("Pause")) 
				{
					undo_bt.setEnabled(true);
					PauseCommand pauseCmd;
					pauseCmd = new PauseCommand(gameObservable);
					breakout.getControlButtons().setCommand(pauseCmd);
					breakout.getControlButtons().press();
					pause_bt.setText("Resume");
				}
				else 
				{
					undo_bt.setEnabled(true);
					isStart = true;
					ResumeCommand resumeCmd;
					resumeCmd = new ResumeCommand(gameObservable);
					breakout.getControlButtons().setCommand(resumeCmd);
					breakout.getControlButtons().press();
					game.requestFocusInWindow();
					pause_bt.setText("Pause");
				}
			}
		});

		undo_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				start_bt.setEnabled(true);
				pause_bt.setEnabled(true);
				undo_bt.setEnabled(true);
				replay_bt.setEnabled(false);
				gameObservable.addObserver(breakout.getControlButtons());
				pause_bt.setText("Resume");
				isStart = false;
				UndoCommand undoCmd;
				undoCmd = new UndoCommand(gameObservable);
				setCommand(undoCmd);
				press();
			}
		});

		replay_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				start_bt.setEnabled(true);
				start_bt.setText("Restart");
				pause_bt.setEnabled(false);
				undo_bt.setEnabled(false);
				replay_bt.setEnabled(true);
				isStart = false;
				ReplayCommand replyCmd;
				gameObservable.addObserver((Observer) breakout.getGameBoard());
				gameObservable.addObserver((Observer) breakout.getDisplayClock());
				gameObservable.addObserver((Observer) breakout.getControlButtons());
				replyCmd = new ReplayCommand(gameObservable);
				setCommand(replyCmd);
				press();
			}
		});
		
		quit_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				System.exit(0);
			}
		});

		setBackground(Color.black);
	}
	
	@Override
	public void update(Observable o, Object objList) 
	{
		if (((ArrayList<?>) objList).get(((ArrayList<?>) objList).size() - 1) instanceof Number) 
		{
			setLayoutState((Integer) ((ArrayList<?>) objList)
					.get(((ArrayList<?>) objList).size() - 1));
		}
	}
	
	//Getters and Setters
	
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

	public GameObservable getTimerObs() {
		return gameObservable;
	}

	public void setTimerObs(GameObservable timerObs) {
		this.gameObservable = timerObs;
	}

	public GameBoard getGame() {
		return game;
	}

	public void setGame(GameBoard game) {
		this.game = game;
	}

	public GameTimer getClock() {
		return clock;
	}


	public void setClock(GameTimer clock) {
		this.clock = clock;
	}

	public void press() {
		command.execute();
	}

	public void setGameDriver(Breakout gameDriver) {
		this.breakout = gameDriver;
	}

	public Breakout getGameDriver() {
		return breakout;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public int getLayoutState()
	{
		return layoutState;
	}

	public void setLayoutState(int layoutState)
	{
		this.layoutState = layoutState;
	}
}