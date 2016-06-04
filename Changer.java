package nl.ru.ai.nakkerts.week4;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Changer implements ChangeListener {
	
	private int index, thickness;
	private double x1, x2, y1, y2;
	private DrawPanel panel;
	
	public Changer(DrawPanel panel){
		this.panel = panel;
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()){
			thickness = source.getValue();
			panel.setThickness(thickness);
		}
		
	}

}
