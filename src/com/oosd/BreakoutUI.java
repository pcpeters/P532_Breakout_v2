package com.oosd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BreakoutUI extends JFrame {
	
	private GameBoard game;
	private Menu menu;
	private MenuButtons menuButtons;
	
	GameObservable observable;
	
	public BreakoutUI(){
		
		game = new GameBoard();
		//menuButtons = new MenuButtons(game);
		
		setMinimumSize(this.getSize());
		
	}


	private void init(GameBoard game, Menu menu){
		
		setLayout(new BorderLayout());
		add(game);
		//add(menu, BorderLayout.SOUTH);
		pack();
		setTitle("Breakout");
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Getter and Setters
	public GameBoard getGame() {
		return game;
	}


	public void setGame(GameBoard game) {
		this.game = game;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public MenuButtons getMenuButtons() {
		return menuButtons;
	}


	public void setMenuButtons(MenuButtons menuButtons) {
		this.menuButtons = menuButtons;
	}


	public GameObservable getObservable() {
		return observable;
	}


	public void setObservable(GameObservable observable) {
		this.observable = observable;
	}


	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				BreakoutUI breakoutUI = new BreakoutUI();
				breakoutUI.setVisible(true);
				//breakoutUI.getMenuButtons()
				
			}
		
			
		});
		
	}
}
