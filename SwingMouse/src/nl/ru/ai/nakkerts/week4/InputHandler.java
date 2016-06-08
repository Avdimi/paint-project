package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputHandler implements ActionListener {
	private DrawPanel panel;
	private double x1, x2, y1, y2, diffx, diffy;
	private int index;
	private Color color;
	private Mode currentMode;
	public InputHandler(DrawPanel panel) {
	this.panel = panel;
	}
	private enum Mode {
		RECTANGLE, ELLIPSE, LINE, RESIZE, COLOR, REMOVE, BORDER, FILL, NONE, IMAGE, TEXT;
	}

	private void placeRect() {
		if (true) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Place Rectangle");
				x1 = evt.getX();
				y1 = evt.getY();
				//System.out.println(x1 + "   " + y1);
				index = panel.addRectangle(x1, y1, x1+5, y1+5);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if(index != -1) {
							panel.setRectangle(index, x1, y1, x2, y2);
						}
					}
				});
			} 
		});
	}

	private void placeEllipse() {
		if (true) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Place Elipse");
				x1 = evt.getX();
				y1 = evt.getY();
				index = panel.addEllipse(x1, y1, x1+5, y1+5);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if(index != -1) {
							panel.setEllipse(index, x1, y1, x2, y2);
						}
					}
				});
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
	
	private void placeLine() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Place Line");
				x1 = evt.getX();
				y1 = evt.getY();
				System.out.println("x1:" + x1 + " y1:" + y1);
				index = panel.addLine(x1, y1, x1+5, y1+5);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if(index != -1) {
							panel.setLine(index, x1, y1, x2, y2);
						}
					}
				});
			} 
		});
	}
	
	private void removeClicked() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Remove Shape");
				double x = evt.getX();
				double y = evt.getY();
				panel.removeShapeAt(x, y);
				
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Rectangle")) {
			placeRect();
			// panel.addRectangle(x,y);
		} else if (e.getActionCommand().equals("Ellipse")) { 
			panel.record("Pressed Button: " + e.getActionCommand());			
			placeEllipse();
		} else if (e.getActionCommand().equals("Line")) { // set mode line
			panel.record("Pressed Button: " + e.getActionCommand());
			placeLine();
		} else if (e.getActionCommand().equals("Fill")) { // set mode random
			panel.record("Pressed Button: " + e.getActionCommand());
			fillShape();			
		} else if (e.getActionCommand().equals("To Front")) { // set mode modrandom
			panel.record("Pressed Button: " + e.getActionCommand());
			moveToFront();
		} else if (e.getActionCommand().equals("Remove")) { // set mode remove 
			panel.record("Pressed Button: " + e.getActionCommand());
			removeClicked();
		} else if (e.getActionCommand().equals("Resize")) { // set mode resize
			panel.record("Pressed Button: " + e.getActionCommand());
			changeShape();
		} else if (e.getActionCommand().equals("Move")) { // set mode resize
			panel.record("Pressed Button: " + e.getActionCommand());
			moveClicked();
		} else if (e.getActionCommand().equals("Borders")) { // set mode resize
			panel.record("Pressed Button: " + e.getActionCommand());
			setBorder();
		} else if (e.getActionCommand().equals("Image")) {
			panel.record("Pressed Button: " + e.getActionCommand());
			placeImage();			
		} else if (e.getActionCommand().equals("To Back")){
			panel.record("Pressed Button: " + e.getActionCommand());
			moveToBack();
		}

	}

	private void placeImage() {
		if (true)
			removeListener();
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Place Image");
				x1 = evt.getX();
				y1 = evt.getY();
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG images", "jpg", "png");
		        fc.setFileFilter(filter);
		        int returnVal = fc.showOpenDialog(panel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					String path = file.getPath();
					panel.addImage(x1, y1, path);
				}

			}
		});

	}

	private void fillShape() {
		
	if(true)removeListener(); // er komt waarschijnlijk nog wel iets anders dan true in de if
	panel.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mousePressed(java.awt.event.MouseEvent evt) {
			panel.record("Clicked to Fill Shape");
			x1 = evt.getX();
			y1 = evt.getY();
			index = panel.getIndex(x1, y1);
			panel.fillShape(index);
	}
		});
	}

	private void moveToFront() {
		if ((panel.getMouseListeners() != null)
				|| (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Move to Front");
				x1 = evt.getX();
				y1 = evt.getY();
				index = panel.getIndex(x1, y1);
				if (index!= -1) {
					panel.moveToFront(index);
				}			
		}
			});
		
	}
	
	private void moveToBack() {
		if ((panel.getMouseListeners() != null)
				|| (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Move to Back");
				x1 = evt.getX();
				y1 = evt.getY();
				index = panel.getIndex(x1, y1);
				if (index!= -1) {
					panel.moveToBack(index);
				}			
		}
			});
		
	}
	
	private void setBorder() {
		if ((panel.getMouseListeners() != null)
				|| (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to change Borders");
				x1 = evt.getX();
				y1 = evt.getY();
				index = panel.getIndex(x1, y1);
				if (index != -1) {
					 
					panel.changeBorder(index, x1, y1, x1, y1, panel.getColor() );
				}
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if (index != -1) {
							panel.changeBorder(index, x1, y1, x2, y2, panel.getColor());
					}
						}
				});
			}

			public void mouseReleased(java.awt.event.MouseEvent evt2) {
				x2 = evt2.getX();
				y2 = evt2.getY();
				if (index != -1) {
					 
					panel.changeBorder(index, x1, y1, x2, y2, panel.getColor());
			}}
		});
	}
	
	private void moveClicked() {
		if ((panel.getMouseListeners() != null)
				|| (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to move a shape");
				x1 = evt.getX();
				y1 = evt.getY();
				diffx = panel.getDiffX(x1, y1);
				diffy = panel.getDiffY(x1, y1);
				index = panel.getIndex(x1, y1);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if (index != -1) {panel.moveShape(diffx, diffy, x2, y2, index);
					}}
				});
			}

			public void mouseReleased(java.awt.event.MouseEvent evt2) {
				x2 = evt2.getX();
				y2 = evt2.getY();
				if (index != -1) {
					panel.moveShape(diffx, diffy, x2, y2, index);
			}}
		});
	}

	private void changeShape() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				panel.record("Clicked to Resize");
				x1 = evt.getX();
				y1 = evt.getY();
				index = panel.getIndex(x1, y1);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						if(index != -1) {
							panel.changeShape(index, x1, y1, x2, y2);
						}
					}
				});
			} 
		});
	}			
}
