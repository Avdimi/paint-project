package nl.ru.ai.nakkerts.week4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	public Window() {

		super();
		setTitle("Paintorz");
		setSize(new Dimension(1280, 720)); // Niet wat klein? 1280 x 720
											// misschien? Of standaard 90% van
											// screensize. Hoe komen we achter
											// screen size?
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setVisible(true);

		DrawPanel rp = new DrawPanel();
		rp.setBackground(new Color(255, 255, 255));
		ButtonPanel bp = new ButtonPanel(rp);
		ButtonPanelColor bpc = new ButtonPanelColor(rp);
		getContentPane().add((Component) rp, "Center");
		getContentPane().add((Component) bp, "West");
		getContentPane().add((Component) bpc, "North");
		rp.setBP(bp);
	}

}