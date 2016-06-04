package nl.ru.ai.nakkerts.week4;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TextPanel extends JPanel {
	public TextPanel(DrawPanel panel){
		super();
		JButton button1 = new JButton("text");
		add(button1);
		InputHandlerText IHT = new InputHandlerText(panel);
		button1.addActionListener(IHT);
		
	}

}
