package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Line2D;
// WERKT NIET. IS EVENTUEEL LEUK VOOR LATER, MAAR IS NIET NODIG. JE MOET MET POLYGON IETS TEKENEN
public class MyTriangle implements Drawable {

	private double x1, x2, x3, y1, y2, y3;
	private Color color;
	private DrawPanel panel;

	public MyTriangle() {
	}

	public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;

	}

	int xPoly[] = { (int) x1, (int) x2, (int) x3 };
	int yPoly[] = { (int) y1, (int) y2, (int) y3 };

	@Override
	public void draw(Graphics2D g) {
		Polygon poly = new Polygon(xPoly, yPoly, 3);
		g.setColor(color);
		g.fill(poly);
		g.drawPolygon(poly);
		
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.x3 = (x1 + x2) / 2;
		this.y3 = (y1 + y2) / 2;

	}
	
	public double[] getcoordinates() {
		double[] coords = new double[4];
		coords[0] = this.x1;
		coords[1] = this.y1;
		coords[2] = this.x2;
		coords[3] = this.y2;
		return coords;
	}

	public void setPanel(DrawPanel drawPanel) {
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean amShape(String shapeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double leftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double topY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBorder(int width, Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fill(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeShape(double x2, double y2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getRawLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRawWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setThickness(int thickness) {
		// didn't read lol
		
	}

}
