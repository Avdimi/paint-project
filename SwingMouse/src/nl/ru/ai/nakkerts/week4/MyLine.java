package nl.ru.ai.nakkerts.week4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

public class MyLine implements Drawable {

	private double x1, x2, y1, y2;
	private Color color, colorB;
	private int thickness = 2;
	private Line2D line;

	public MyLine() {
	}

	public MyLine(double x1, double y1, double x2, double y2) {
		this.x1 = x1; // coordinates added are x1, y1 and x2 and y2 are in
						// relation to that
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics2D g) {
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g.setColor(color);
		Stroke border = new BasicStroke(thickness);
		g.setColor(colorB);
		g.setStroke(border);
		g.draw(line);

	}

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
		double diffX = x1-x2; 
		double diffY = y1-y2;
		double  a = diffY/diffX;
		double  b = regressie(a,x1,x2,y1); 
		double  yv = (a*x + b);
				    if ((yv + (5 +thickness) > y) && (yv -(5 + thickness) < y) && (((x1 > x) &&(x > x2))|| ((x1 < x) &&(x < x2))))  
		    	return true;
		    else return false;
	}

	private double regressie(double a, double x1, double x2, double y1) {
		// if (x1 < x2) {
		return -(a * x1 - y1);
		// } else return (a*x2 - y1);

	}

	@Override
	public boolean amShape(String shapeName) {
		return shapeName == "line";
	}

	@Override
	public double leftX() {
		return x1;	}

	@Override
	public double topY() {
		return y1;//Math.min(y1, y2);
	}

	@Override
	public double getLength() {
		return Math.abs(y1 - y2);
	}

	@Override
	public double getWidth() {
		return Math.abs(x1 - x2);
	}
	
	public double getRawLength() {
		return y2- y1;
	}
	
	public double getRawWidth() {
		return x2-x1;
	}

	@Override
	public void setBorder(int width, Color color) {
		int vector = (int) Math.sqrt(Math.pow(Math.abs(x1 - x2), 2)
				+ Math.pow(Math.abs(y1 - y2), 2));
		thickness = Math.min(width, vector / 3);
		colorB = color;

	}

	@Override
	public void fill(Color color) {
		this.color = color;
		this.colorB = color;
	}

	@Override
	public void setThickness(int thickness) {
		this.thickness = thickness;
		
	}

}
