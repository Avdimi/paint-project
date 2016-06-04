package nl.ru.ai.nakkerts.week4;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class ButtonPanel extends JPanel {
	public ButtonPanel(DrawPanel panel) {
		super();

		JButton button3 = new JButton("Rectangle");
		JButton button4 = new JButton("Ellipse");
		JButton button5 = new JButton("Line");
		JButton button6 = new JButton("Move");
		JButton button1 = new JButton("Fill");
		JButton button7 = new JButton("To Front");
		JButton button0 = new JButton("Remove");
		JButton button9 = new JButton("Resize");
		JButton button2 = new JButton("Borders");
		JButton button12 = new JButton("Text");
		JButton button11 = new JButton("Image");
		JButton button8 = new JButton("To Back");
	
		
		// het dropdown menu voor textsize
		InputHandlerText IHT = new InputHandlerText(panel);
		//Integer[] sizes = {8,10,12,14,16,18,20,24,28,32,36,40};
		//JComboBox sizeList = new JComboBox(sizes);
		//sizeList.setSelectedIndex(2);
		//sizeList.addActionListener(IHT);
		
		//slider voor thickness
		final int MIN = 0;
		final int MAX = 20;
		final int INIT = 2;
		
		JSlider thickness = new JSlider(JSlider.VERTICAL,MIN, MAX, INIT);

		thickness.setMinorTickSpacing(1);
		thickness.setMajorTickSpacing(5);
		thickness.setPaintTicks(true);
		thickness.setPaintLabels(true);




		Changer ch = new Changer(panel);
		Font font = new Font("Serif", Font.PLAIN, 14);
		thickness.setFont(font);
		thickness.addChangeListener(ch);

		Dimension buttonDim = new Dimension(95, 25);
		button1.setPreferredSize(buttonDim);
		button2.setPreferredSize(buttonDim);
		button3.setPreferredSize(buttonDim);
		button4.setPreferredSize(buttonDim);
		button5.setPreferredSize(buttonDim);
		button6.setPreferredSize(buttonDim);
		button7.setPreferredSize(buttonDim);
		button8.setPreferredSize(buttonDim);
		button9.setPreferredSize(buttonDim);
		button0.setPreferredSize(buttonDim);
		button11.setPreferredSize(buttonDim);
		button12.setPreferredSize(buttonDim);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel sliderLabel = new JLabel("Line & Border Thickness", JLabel.CENTER);
		sliderLabel.setLabelFor(thickness);
		sliderLabel.setHorizontalTextPosition(JLabel.CENTER);
		sliderLabel.setVerticalTextPosition(JLabel.NORTH);
		gbc.gridy = 0;
		add((Component) sliderLabel, gbc );
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(1, 1, 1, 1);
		add((Component) button1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add((Component) button2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add((Component) button3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		add((Component) button4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		add((Component) button5, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		add((Component) button6, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		add((Component) button7, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		add((Component) button8, gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		add((Component) button9, gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		add((Component) button0, gbc);
		gbc.gridx = 0;
		gbc.gridy = 12;
		add((Component) button11, gbc);
		gbc.gridx = 0;
		gbc.gridy = 14;
		//add((Component) sizeList, gbc);
		gbc.gridy = 13;
		add((Component) button12, gbc);
		gbc.gridy = 1;
		gbc.ipady = 60;
		gbc.ipadx = 20;
		add((Component) thickness, gbc);
		

		InputHandler IH = new InputHandler(panel);
		
		button1.addActionListener(IH);
		button2.addActionListener(IH);
		button3.addActionListener(IH);
		button4.addActionListener(IH);
		button5.addActionListener(IH);
		button6.addActionListener(IH);
		button7.addActionListener(IH);
		button8.addActionListener(IH);
		button9.addActionListener(IH);
		button0.addActionListener(IH);
		button11.addActionListener(IH);
		button12.addActionListener(IHT);

	}
}