package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private Color color, colorB;
	private Random rand = new Random();
	private int index = 0, size = 8, listIndex;
	private int thickness;
	ArrayList<Drawable> shapesList = new ArrayList<Drawable>();
	ArrayList<ArrayList<Drawable>> history = new ArrayList <ArrayList<Drawable>>();

	public DrawPanel() {
		super();
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Drawable s : shapesList)
			s.draw(g2d);

	}

	public void setRandomColor() {

		int R = rand.nextInt(256);
		int G = rand.nextInt(256);
		int B = rand.nextInt(256);
		Color color = new Color(R, G, B);
		this.color = color;
		repaint();
	}

	public void addRandomShape() {
		this.color = getRandomColor();
		int flip = getRandomInt(13);
		double x1 = rand.nextInt(550) + 50, x2 = rand.nextInt(550) + 50;
		double y1 = rand.nextInt(350) + 50, y2 = rand.nextInt(350) + 50;

		switch (flip) {
		case 0:
			MyRectangle rect = new MyRectangle();
			rect.setCoordinates(x1, x2, y1, y2);
			rect.setColor(color);
			shapesList.add(rect);
			break;
		case 1:
			MyEllipse elipse = new MyEllipse(x1, y1, 30, 70);
			// elipse.setCoordinates(x1, x2, y1, y2);
			elipse.setColor(color);
			shapesList.add(elipse);
			break;
		case 8:
			MyLine diagRight = new MyLine(x1, x1 + 50, y1, y1 + 50);
			diagRight.setColor(color);
			shapesList.add(diagRight);
			break;
		case 9:
			MyLine hor = new MyLine(x1, x1 + 50, y1, y1);
			hor.setColor(color);
			shapesList.add(hor);
			break;
		case 10:
			MyLine vert = new MyLine(x1, x1, y1, y1 + 50);
			vert.setColor(color);
			shapesList.add(vert);
			break;
		case 11:
			MyLine diagLeft = new MyLine(x1, x1 - 50, y1, y1 - 50);
			diagLeft.setColor(color);
			shapesList.add(diagLeft);
			break;
		case 13: // triangle werkt helaas niet meer
			MyTriangle triangle = new MyTriangle();
			triangle.setPanel(this);
			triangle.setColor(color);
			triangle.setCoordinates(x1, y1, x2, y2);
			shapesList.add(triangle);
			break;
		case 12:
			MyEllipse circle = new MyEllipse(x1 - 30, y1 - 30, 40, 40);
			circle.setColor(color);
			shapesList.add(circle);
			break;
		}

		repaint();
		this.index = shapesList.size() - 1;
	}

	public Color getRandomColor() {
		int R = rand.nextInt(256);
		int G = rand.nextInt(256);
		int B = rand.nextInt(256);
		Color color = new Color(R, G, B);
		return color;
	}

	public int getRandomInt(int bound) {
		int flip = rand.nextInt(bound);
		if (flip < 4) {
			flip = 0;
		} else if ((flip >= 4) && (flip < 8)) {
			flip = 1;
		}
		return flip;
	}

	public void removePreviousShape() {
		int index = shapesList.size() - 1;
		if (index >= 0) {
			shapesList.remove(index);
			repaint();
		}
		this.index = index - 1;
	}

	public void alterNextShape() {
		if (shapesList.size() > 0) {
			// int length = shapesList.size();
			int flip = getRandomInt(12);
			this.color = getRandomColor();
			double x1 = rand.nextInt(650) + 50, x2 = rand.nextInt(650) + 50, x3 = rand
					.nextInt(650) + 50;
			double y1 = rand.nextInt(450) + 50, y2 = rand.nextInt(450) + 50, y3 = rand
					.nextInt(450) + 50;

			switch (flip) {
			case 0:
				MyRectangle rect = new MyRectangle();
				rect.setCoordinates(x1, x2, y1, y2);
				rect.setColor(color);
				shapesList.set(index, rect);
				break;
			case 1:
				MyEllipse elipse = new MyEllipse(x1, y1, 50, 50);
				elipse.setColor(color);
				shapesList.set(index, elipse);
				break;
			case 8:
				MyLine diagRight = new MyLine(x1, x1 + 50, y1, y1 + 50);
				diagRight.setColor(color);
				shapesList.set(index, diagRight);
				break;
			case 9:
				MyLine hor = new MyLine(x1, x1 + 50, y1, y1);
				hor.setColor(color);
				shapesList.set(index, hor);
				break;
			case 10:
				MyLine vert = new MyLine(x1, x1, y1, y1 + 50);
				vert.setColor(color);
				shapesList.set(index, vert);
				break;
			case 11:
				MyLine diagLeft = new MyLine(x1, x1 - 50, y1, y1 - 50);
				diagLeft.setColor(color);
				shapesList.set(index, diagLeft);
				break;
			case 12: // triangle werkt helaas niet meer
				MyTriangle triangle = new MyTriangle(x1, y1, x2, y2, x3, y3);
				shapesList.set(index, triangle);
				break;
			}// switch end
		} // if check
		repaint();
		index -= 1;
		if (index < 0) {
			index = shapesList.size() - 1;
		}
	}

	public int addRectangle(double x1, double y1, double x2, double y2) {
		MyRectangle rect = new MyRectangle();
		rect.setCoordinates(x1, y1, x2, y2);
		rect.setColor(color);
		rect.setBorder(thickness, color);
		shapesList.add(rect);
		repaint();
		this.index = shapesList.size() - 1;
		return index;
	}

	public int addEllipse(double x1, double y1, double x2, double y2) {
		MyEllipse elipse = new MyEllipse();
		elipse.setCoordinates(x1, y1, x2, y2);
		elipse.setColor(color);
		elipse.setBorder(thickness, color);
		shapesList.add(elipse);
		repaint();
		this.index = shapesList.size() - 1;
		return index;
	}

	public int addLine(double x1, double y1, double x2, double y2) {
		MyLine line = new MyLine();
		line.setColor(color);
		line.setCoordinates(x1, y1, x2, y2);
		shapesList.add(line);
		repaint();
		this.index = shapesList.size() - 1;
		return index;
	}

	public void removeShapeAt(double x, double y) {
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x, y)) {
				shapesList.remove(i);
				index = index - 1;
				i = 0; // comment dit eruit en je delete alles op punt x,y. De
						// for-loop stopt namelijk bij i =0
			}
		}

		repaint();
	}

	public void changeColor(double x1, double y1, Color color2) {
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x1, y1)) {
				Drawable temp = shapesList.get(i);
				temp.setColor(color2);
				shapesList.set(i, temp);
				i = 0;
			}
		}
		repaint();
	}

	public void changeShape(int i, double x1, double y1, double x2, double y2) {
		Drawable temp = shapesList.get(i);
		temp.changeShape(x2, y2); // je veranderd alleen x2 en y2 zodat x1 en y1
									// stationary blijven
		shapesList.set(i, temp);
		repaint();

	}

	public double getDiffX(double x1, double y1) {
		double diffX = -1;
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x1, y1)) {
				Drawable temp = shapesList.get(i);
				double shapex1 = temp.leftX();
				diffX = Math.abs((x1 - shapex1));
				i = 0;
				return diffX;
			}
		}
		return diffX;
	}

	public double getDiffY(double x1, double y1) {
		double diffY = -1;
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x1, y1)) {
				Drawable temp = shapesList.get(i);
				double shapey1 = temp.topY();
				diffY = ((y1 - shapey1));
				i = 0;
				return diffY;
			}
		}
		return diffY;
	}

	public void moveShape(double diffx, double diffy, double x2, double y2,
			int i) {
		Drawable temp = shapesList.get(i);
		double height = temp.getRawLength();
		double width = temp.getRawWidth();
		temp.setCoordinates((x2 - diffx), (y2 - diffy), ((x2 - diffx) + width),
				((y2 - diffy) + height));
		shapesList.set(i, temp);
		repaint();
	}

	public int getIndex(double x1, double y1) {
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x1, y1))
				return i;
		}
		return -1;
	}

	public void changeBorder(int i, double x1, double y1, double x2, double y2,
			Color colorB) {
		Drawable temp = shapesList.get(i);
		double shapeHeight = temp.getLength();
		double shapeWidth = temp.getWidth();
		double diffX = Math.abs(x1 - x2);
		double diffY = Math.abs(y1 - y2);
		double vectLength = Math.sqrt(Math.pow(diffY, 2) + Math.pow(diffX, 2));
		double absDiff = Math.abs(Math.min(shapeHeight, shapeWidth)) / 5;
		//int thickness = 1 + (int) vectLength / 4;
		temp.setBorder(thickness, colorB);//(Math.min(thickness, (int) absDiff), colorB);
		repaint();
	}

	public void setRectangle(int i, double x1, double y1, double x2, double y2) {
		Drawable temp = shapesList.get(i);
		temp.setCoordinates(x1, y1, x2, y2);
		temp.setThickness(thickness);
		repaint();
	}

	public void setEllipse(int i, double x1, double y1, double x2, double y2) {
		Drawable temp = shapesList.get(i);
		temp.setCoordinates(x1, y1, x2, y2);
		temp.setThickness(thickness);
		repaint();		
	}

	public void setLine(int i, double x1, double y1, double x2, double y2) {
		Drawable temp = shapesList.get(i);
		temp.setCoordinates(x1, y1, x2, y2);
		temp.setThickness(thickness);
		repaint();		
	}

	public void fillShape(int index) {
		if (index == -1) {
			this.setBackground(color);
		} else {
			Drawable temp = shapesList.get(index);
			temp.fill(color);
			shapesList.set(index, temp);
		}
		repaint();
	}

	public void moveToFront(int i) {
		Drawable temp = shapesList.get(i);
		shapesList.add(temp);
		shapesList.remove(i);
		repaint();
	}
	
	public void moveToBack (int i) {
		Drawable temp = shapesList.get(i);
		shapesList.remove(i);
		shapesList.add(0, temp);
		repaint();
		this.index = shapesList.size() -1;
	}

	public void addText(int x1, int y1, String text, int index2) {
		Font font = new Font("Serif", Font.PLAIN, size);
		myText textshape = new myText(x1, y1, this.color, font, text);
		if (index2 == -1){
			shapesList.add(textshape);
			repaint();
		this.index = shapesList.size() - 1;
		} else if (index2 != -1){
			myText temp = (myText)shapesList.get(index2);
			temp.setText(text);
			temp.setFont("serif", Font.PLAIN, size);
			shapesList.remove(index2);
			shapesList.add(index2, temp);
			repaint();
		}
	}

	public void addImage(double x1, double y1, String path) {
		MyImage image = new MyImage(x1, y1, path);
		shapesList.add(image);
		repaint();
		this.index = shapesList.size() - 1;
	}

	public void setTextSize(int size) {
		this.size = size;
		
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
		
	}

}
