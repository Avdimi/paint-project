package nl.ru.ai.nakkerts.week4;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class InputHandlerText implements ActionListener {
	private DrawPanel panel;
	private int size;
	private Font font;
	private int x1, x2, y1, y2;

	public InputHandlerText(DrawPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Text")) {
			panel.record(e.getActionCommand());
			placeText();
			
		} else {
			JComboBox cb = (JComboBox)e.getSource();
			size = (int)cb.getSelectedItem();
			panel.setTextSize(size);
		}

	}

	private void placeText() {
		removeListener();
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				x1 = evt.getX();
				y1 = evt.getY();
				panel.record("Pressed Mouse to place Text");
				int index = panel.getIndex(x1, y1);

				String text = JOptionPane.showInputDialog(panel, "Enter text:",
						"Text");
				Integer[] sizes = {8,10,12,14,16,18,20,24,28,32,36,40};
				int size = (int) JOptionPane.showInputDialog(null,"Choose text size", "Textsize", JOptionPane.QUESTION_MESSAGE, null, sizes, sizes[1]);
				panel.setTextSize(size);
				if (text != null){
				panel.addText(x1, y1, text, index);
				panel.record("Text Added");
				} else if (text == null) {
					panel.record("Cancelled Text Input");
				}
				// System.out.println(x1 + "   " + y1);
			}
		});

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

}
