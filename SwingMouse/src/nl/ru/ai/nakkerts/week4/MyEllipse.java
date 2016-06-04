package nl.ru.ai.nakkerts.week4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

public class MyEllipse implements Drawable {

	private double x1, y1, x2, y2;
	private Color color, colorB;
	private int thickness = 1;
	private Ellipse2D e;
	private boolean fill;

	public MyEllipse() {
	}

	public MyEllipse(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.colorB = color;
	}

	@Override
	public void draw(Graphics2D g) {
		double x = getStartX(x1,x2);
		double y = getStartY(y1,y2);
		double width = Width(x1,x2);
		double height = Height(y1,y2);
		e = new Ellipse2D.Double(x, y, width, height);
		g.setColor(color);
		if(fill) g.fill(e);
		Stroke border = new BasicStroke(thickness);
		g.setColor(colorB);
		g.setStroke(border);
		g.draw(e);
	}

	private double Width(double x1, double x2) {
		return Math.abs(x1-x2);
	}

	private double Height(double y1, double y2) {
		return Math.abs(y1-y2);
	}

	private double getStartX(double x1, double x2) {
		return Math.min(x1, x2);
	}

	private double getStartY(double y1, double y2) {
		return Math.min(y1, y2);
	}
/** 
 * sets ellipse coordinates with the smallest of (x1,x2) and the smallest of (y1,y2) as the top left location.
 * 
 */
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void changeShape(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public boolean contains(double x, double y) {
		double diffX = Math.abs(x1-x2);
		double diffY = Math.abs(y1-y2);
		if ((diffX < 2) || (diffY < 2)) {
			if (((x1<=x && x<=x2) || (x2<=x && x<=x1))  &&  ((y1<=y && y<=y2) || (y2<=y && y<=y1))){
				return true;
			}
			else {
				return false;
			}
		}else {
			return e.contains(x,y);
		}

	}

	@Override
	public boolean amShape(String shapeName) {
		return shapeName == "Ellipse";
	}

	@Override
	public double leftX() {
		// TODO Auto-generated method stub
		return Math.min(x1, x2);
	}
	@Override
	public double topY() {
		// TODO Auto-generated method stub
		return Math.min(y1, y2);
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return Height(y1,y2);
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return Width(x1,x2);
	}

	@Override
	public void setBorder(int width, Color color) {
		int vector = (int)Math.sqrt(Math.pow(Math.abs(x1 - x2),2) + Math.pow(Math.abs (y1-y2),2));
		thickness = Math.min(width, vector/3);
		this.colorB = color;		
	}

	@Override
	public void fill(Color color) {
		this.color = color;
		fill = true;		
	}

	@Override
	public double getRawLength() {
		// TODO Auto-generated method stub
		return getLength();//(y2-y1);
	}

	@Override
	public double getRawWidth() {
		// TODO Auto-generated method stub
		return getWidth();//(x2-x1);
	}

	@Override
	public void setThickness(int thickness) {
		this.thickness = thickness;
		
	}
}
