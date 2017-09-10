package com.oosd;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuBoard extends JPanel implements Constants
{
	public MenuBoard(GameBoard game, MenuButtons controlButtons, GameTimer clock) 
	{
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		this.add(controlButtons);
		this.add(clock.jp);
		setBackground(Color.black);
	}
}
