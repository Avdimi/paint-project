package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage implements Drawable {
	private double x1, x2, y1, y2;
	private String path;
	private Image image;
	private Color color;
	

	public MyImage(double x1, double y1, String path) {
		this.x1 = x1;
		this.y1 = y1;
		this.path = path;
		try {
            this.image = ImageIO.read(new File(path));
            this.x2 = x1 + this.image.getWidth(null);
            this.y2 = y1 + this.image.getHeight(null);
        }
        catch (IOException e) {
            e.printStackTrace();
       }
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawImage(image, (int)x1, (int)y1, (int)(x2-x1), (int)(y2-y1), null);
		
	}

	@Override
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
	}

	@Override
	public void changeShape(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
				
		
	}

	@Override
	public boolean contains(double x, double y) {
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
		return x1;
	}

	@Override
	public double topY() {
		// TODO Auto-generated method stub
		return y1;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return Math.abs(y2-y1);
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return Math.abs(x2-x1);
	}

	@Override
	public void setBorder(int width, Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fill(Color color) {
		// not used
		
	}

	@Override
	public double getRawLength() {
		return y2-y1;
	}

	@Override
	public double getRawWidth() {
		return x2-x1;
	}

	@Override
	public void setThickness(int thickness) {
		// not used
		
	}

}
