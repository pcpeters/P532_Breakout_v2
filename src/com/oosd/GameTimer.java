package com.oosd;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTimer implements Observer
{
	JPanel jp = new JPanel();
	JLabel time = new JLabel("00:00");

	public GameTimer()
	{
		FlowLayout layout = new FlowLayout();
		jp.setLayout(layout);
		jp.add(time);
		time.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		time.setForeground(Color.white);
		jp.setBackground(Color.black);
	}

	//Observer updates itself
	@Override
	public void update(Observable oservable, Object objectList)
	{
		if (!(objectList instanceof LinkedList<?>))
		{
			@SuppressWarnings("unchecked")
			ArrayList<Object> obj = (ArrayList<Object>) objectList;
			if (obj.get(0) instanceof Number && ((Integer) obj.get(0)).intValue() == 2){
				time.setText("00:00");
			}				
			else if (obj.get(obj.size() - 2) instanceof String)
			{
				time.setText(obj.get(obj.size() - 2).toString());

			}
		}
	}
}