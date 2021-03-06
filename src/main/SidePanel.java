package main;
//Primary contributor: Osman Wong
//Version number: 2
//Date of completion:5/13/18

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
//Is the panel on the side that shows score and difficulty
public class SidePanel extends JPanel{
//Fields:
	private JTextField difficulty,score, currency;
	private int points,diff,curr;
	ProgressBar hpBar;
//Constructor:
	public SidePanel()
	{
		super(new GridLayout(8,1,0,15));
		this.setBackground(Color.GRAY);
		Font displayFont = new Font("Monospaced", Font.BOLD, 16);
		points=0;
		diff=1;
		hpBar = new ProgressBar(20, 80, 10, 620, 20, 5, Color.GREEN, Color.BLACK);
		add(hpBar);
		add(new JLabel("Score:"));
		score = new JTextField(points);
	    score.setFont(displayFont);
	    score.setEditable(false);
	    score.setBackground(Color.WHITE);
	    add(score);
	    
	    add(new JLabel("On Wave:"));
		difficulty = new JTextField(diff);
	    difficulty.setFont(displayFont);
	    difficulty.setEditable(false);
	    difficulty.setBackground(Color.WHITE);
	    add(difficulty);
	    
	    add(new JLabel("Currency:"));
		currency = new JTextField(curr);
		currency.setFont(displayFont);
		currency.setEditable(false);
		currency.setBackground(Color.WHITE);
	    add(currency);
	}
//Updates the panel's text fields to be the latest
	public void update(int hp, int s, int d,int c)
	{
		hpBar.set(hp);
		points=s;
		diff=d;
		curr=c;
		if(s<100000)
		{
			score.setText(String.valueOf(points));
		}
		else if(s<10000000)
		{
			score.setText(points/1000+"k");
		}
		else
		{
			score.setText("GOD");
		}
		difficulty.setText(String.valueOf(diff));
		if(c<100000)
		{
			currency.setText(String.valueOf(curr));
		}
		else if(c<10000000)
		{
			currency.setText(points/1000+"k");
		}
	}
	//draws it
	public void paintComponent(Graphics g)
	{
		hpBar.draw(g);
	}
	
}
