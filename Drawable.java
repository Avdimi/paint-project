package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Drawable { // ook wel shape
	/**
	 * draw shape according to certain graphic2Ds
	 */
	public void draw(Graphics2D g); 
	
	/**
	 * hiermee geef je de x en y coordinaten aan. Let op de volgorde per shape
	 */
	public void setCoordinates(double x1, double y1, double x2, double y2);
	
	/**
	 * hiermee verander je alleen de het eindpunt van de shape
	 * @param x2
	 * @param y2
	 */
	public void changeShape(double x2, double y2);

	/**
	 * vallen coördinaten (x,y) binnen de shape? 
	 */
	public boolean contains(double x, double y); 

	/**
	 * Changes the color of a shape
	 */
	public void setColor(Color color2); 
	
	/**
	 * Checks String shapeName vs the name of a given shape. Returns true if identical and false if not
	 */
	public boolean amShape(String shapeName);

	public double leftX();

	public double topY();	
	
	public double getLength();
	
	public double getWidth();
	
	public void setBorder(int width, Color color);

	public void fill(Color color);

	public double getRawLength();

	public double getRawWidth();
	
	public void setThickness(int thickness);
	
}
