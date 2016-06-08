package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonPanelColor extends JPanel {
	private JButton end;
	private JButton start;
	public ButtonPanelColor(DrawPanel panel) {
		super();
		Icon black = new ImageIcon("black.jpg");
		JButton button1 = new JButton(black);
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();
		JButton button7 = new JButton();
		JButton button8 = new JButton();
		JButton button9 = new JButton();
		JButton button10 = new JButton();
		JButton button11 = new JButton();
		JButton button12 = new JButton();
		JButton button13 = new JButton();
		JButton button14 = new JButton(); // mirrorbutton
		JButton button15 = new JButton();
		JButton button16 = new JButton();
		JButton button17 = new JButton();
		start 	= new JButton("Start");
		end		= new JButton("End");
		
		Dimension buttonDim = new Dimension(25, 25);
		InputHandlerText IHT = new InputHandlerText(panel);
		
		Integer[] sizes = {8,10,12,14,16,18,20,24,28,32,36,40};
		JComboBox sizeList = new JComboBox(sizes);
		sizeList.setSelectedIndex(0);
		sizeList.addActionListener(IHT);
		Color brown = new Color(153,76,0);
		Color DarkGreen = new Color (0,153,76);
		Color DarkPurple = new Color (102,0,102);
		
		start.setPreferredSize(new Dimension(65,20));
		end.setPreferredSize(new Dimension(65,20));
		button14.setPreferredSize(new Dimension(40, 40));
		button16.setPreferredSize(buttonDim);
		button16.setBackground(DarkGreen);
		button17.setPreferredSize(buttonDim);
		button17.setBackground(DarkPurple);
		button15.setPreferredSize(buttonDim);
		button15.setBackground(brown);
		button14.setBackground(Color.black);
		button1.setBackground(Color.black);
		button1.setPreferredSize(buttonDim);
		button2.setBackground(Color.blue);
		button2.setPreferredSize(buttonDim);
		button3.setBackground(Color.cyan);
		button3.setPreferredSize(buttonDim);
		button4.setBackground(Color.darkGray);
		button4.setPreferredSize(buttonDim);
		button5.setBackground(Color.gray);
		button5.setPreferredSize(buttonDim);
		button6.setBackground(Color.lightGray);
		button6.setPreferredSize(buttonDim);
		button7.setBackground(Color.green);
		button7.setPreferredSize(buttonDim);
		button8.setBackground(Color.magenta);
		button8.setPreferredSize(buttonDim);
		button9.setBackground(Color.orange);
		button9.setPreferredSize(buttonDim);
		button10.setBackground(Color.pink);
		button10.setPreferredSize(buttonDim);
		button11.setBackground(Color.red);
		button11.setPreferredSize(buttonDim);
		button12.setBackground(Color.yellow);
		button12.setPreferredSize(buttonDim);
		button13.setBackground(Color.white);
		button13.setPreferredSize(buttonDim);

		button1.setActionCommand("black");
		button2.setActionCommand("blue");
		button3.setActionCommand("cyan");
		button4.setActionCommand("darkgray");
		button5.setActionCommand("gray");
		button6.setActionCommand("lightgray");
		button7.setActionCommand("green");
		button8.setActionCommand("magenta");
		button9.setActionCommand("orange");
		button10.setActionCommand("pink");
		button11.setActionCommand("red");
		button12.setActionCommand("yellow");
		button13.setActionCommand("white");
		button15.setActionCommand("Brown");
		button16.setActionCommand("DarkGreen");
		button17.setActionCommand("DarkPurple");
		start.setActionCommand("Start");
		end.setActionCommand("End");

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1, 1, 1, 1);
		add((Component) button1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add((Component) button4, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add((Component) button5, gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		add((Component) button6, gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		add((Component) button13, gbc);
		gbc.gridx = 5;
		gbc.gridy = 0;
		add((Component) button15, gbc);
		gbc.gridx = 6;
		gbc.gridy = 0;
		add((Component) button16, gbc);
		gbc.gridx = 7;
		gbc.gridy = 0;
		add((Component) button7, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add((Component) button3, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add((Component) button2, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add((Component) button17, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		add((Component) button8, gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		add((Component) button11, gbc);
		gbc.gridx = 5;
		gbc.gridy = 1;
		add((Component) button10, gbc);
		gbc.gridx = 6;
		gbc.gridy = 1;
		add((Component) button9, gbc);
		gbc.gridx = 7;
		gbc.gridy = 1;
		add((Component) button12, gbc);
		gbc.gridx = 10;
		gbc.gridy = 0;
		gbc.insets= new Insets(0,100,0,0);
		add((Component)start,gbc);
		gbc.gridy = 1;
		add((Component)end,gbc);
				
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.gridheight = 2;
		add((Component) button14, gbc);
		
		
		

		button14.setEnabled(false);

		InputHandlerNorth IHC = new InputHandlerNorth(panel, button14);

		button1.addActionListener(IHC);
		button2.addActionListener(IHC);
		button3.addActionListener(IHC);
		button4.addActionListener(IHC);
		button5.addActionListener(IHC);
		button6.addActionListener(IHC);
		button7.addActionListener(IHC);
		button8.addActionListener(IHC);
		button9.addActionListener(IHC);
		button10.addActionListener(IHC);
		button11.addActionListener(IHC);
		button12.addActionListener(IHC);
		button13.addActionListener(IHC);
		button15.addActionListener(IHC);
		button16.addActionListener(IHC);
		button17.addActionListener(IHC);
		start.addActionListener(IHC);
		end.addActionListener(IHC);
		end.setEnabled(false);

	}
	public void start(){
		start.setEnabled(false);
		end.setEnabled(true);
	}
}