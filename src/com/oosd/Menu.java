package com.oosd;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class Menu extends JPanel {
	
	public Menu(GameBoard game, MenuButtons menuButtons) {
		
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		this.add(menuButtons);
		setBackground(Color.black);
		
	}
	
	
}
