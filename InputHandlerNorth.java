package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class InputHandlerNorth implements ActionListener {
	private DrawPanel panel;
	private double x1, y1;
	private Color color;
	private JButton mimic;

	public InputHandlerNorth(DrawPanel panel, JButton mimic) {
		this.panel = panel;
		this.mimic = mimic;
	}

	private void removeListener() {
		MouseMotionListener[] lijst = panel.getMouseMotionListeners();
		for (int b = 0; b < lijst.length; b++) {
			panel.removeMouseMotionListener(lijst[b]);
		}
		MouseListener[] list = panel.getMouseListeners();
		for (int i = 0; i < list.length; i++) {
			panel.removeMouseListener(list[i]);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("black")) {
			color = color.black;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("blue")) {
			color = color.blue;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("cyan")) {
			color = color.cyan;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("darkgray")) {
			color = color.darkGray;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("gray")) {
			color = color.gray;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("lightgray")) {
			color = color.lightGray;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("green")) {
			color = color.green;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("magenta")) {
			color = color.magenta;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("orange")) {
			color = color.orange;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("pink")) {
			color = color.pink;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("red")) {
			color = color.red;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("yellow")) {
			color = color.yellow;
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("white")) {
			color = color.white;
			panel.setColor(color);
			mimic.setBackground(color);			
		} else if(e.getActionCommand().equals("Brown")){
			color = new Color(153,76,0);//brown
			panel.setColor(color);
			mimic.setBackground(color);
		} else if(e.getActionCommand().equals("DarkGreen")){
			color = new Color(0,153,76); //darkGreen
			panel.setColor(color);
			mimic.setBackground(color);
		} else if (e.getActionCommand().equals("DarkPurple")){
			color = new Color(102,0,102);
			panel.setColor(color);
			mimic.setBackground(color);
		}

	}

}
