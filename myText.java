package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class myText implements Drawable {
	private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private Font font;
    private String text;
    private FontMetrics fontMetrics;
    private Graphics2D g;
    
   
    public myText(int x, int y,Color color, Font font, String text){
    	this.x = x;
    	this.y = y;
    	this.color = color;
    	this.font = font;
    	this.text = text;
       }

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x, y);
		this.g = g;
		this.fontMetrics = this.g.getFontMetrics();
		this.width = fontMetrics.stringWidth(text);
		this.height = fontMetrics.getHeight();
	}

	@Override
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x = (int)x1;
		this.y = (int)y1;
		
	}

	@Override
	public void changeShape(double x2, double y2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(double x, double y) {
		int x1 = this.x;
		int y1 = this.y;
		int x2 = this.x + width;
		int y2 = this.y - height;
		
		if (((x1<=x && x<=x2) || (x2<=x && x<=x1))  &&  ((y1<=y && y<=y2) || (y2<=y && y<=y1))){
			return true;
		} else return false;
		
	}

	@Override
	public void setColor(Color color2) {
		this.color = color2;
	}

	@Override
	public boolean amShape(String shapeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double leftX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double topY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return fontMetrics.getHeight();
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return fontMetrics.stringWidth(text);
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
		// TODO Auto-generated method stub
	}
	public void setText (String text){
		this.text = text;
	}

	public void setFont (String font,int fonttype, int size ){
		Font temp = new Font(font, fonttype, size);
		this.font = temp;
	}

}
