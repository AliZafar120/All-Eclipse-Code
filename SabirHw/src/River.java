

import java.awt.Graphics;

public class River extends Shape{
	private Graphics myGraphics;
	private int x1, y1, x2, y2, x3, y3, x4, y4;
	
	public River(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Graphics g){
		/*
	     * It takes top left and right bottom point as parameter
	     * 
	     * */
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
		myGraphics = g;
		buildShape();
	}
	
	@Override
	public void buildShape() {
		// TODO Auto-generated method stub
		lists.add(new Line(x1, y1, x2, y2, myGraphics));
		lists.add(new Line(x3, y3, x2, y2, myGraphics));
		lists.add(new Line(x3, y3, x4, y4, myGraphics));
		int temp = Math.abs(y3 - y2);
		lists.add(new Line(x1, y1 + temp, x2 - temp, y2 + temp, myGraphics));
		lists.add(new Line(x3 - temp, y3  + temp, x2 - temp, y2 + temp, myGraphics));
		lists.add(new Line(x3 - temp, y3 + temp, x4, y4 + temp, myGraphics));
		
	}

}
