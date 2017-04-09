

import java.awt.Graphics;

public class Rectangle extends Shape{
	private Graphics myGraphics;
	private int x1, y1, x2, y2;
	
	public Rectangle(int x1, int y1, int x2, int y2, Graphics g){
		/*
	     * It takes top left and right bottom point as parameter
	     * 
	     * */
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		myGraphics = g;
		buildShape();
	}

	@Override
	public void buildShape() {
		// TODO Auto-generated method stub
		lists.add(new Line(x1, y1, x1, y2, myGraphics));
		lists.add(new Line(x1, y1, x2, y1, myGraphics));
		lists.add(new Line(x2, y2, x1, y2, myGraphics));
		lists.add(new Line(x2, y2, x2, y1, myGraphics));
	}
	
	
}
