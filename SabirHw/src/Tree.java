

import java.awt.Graphics;

public class Tree extends Shape{
	private Graphics myGraphics;
	int x1, y1, x2, y2;
	public Tree(int x1, int y1, int x2, int y2, Graphics g){
		/*
	     * It takes two points of the vertical line of a tree as parameter
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
		lists.add(new Line(x1, y1, x2, y2, myGraphics));
		int temp = (int)(Math.abs(y2-y1)*.33);
		lists.add(new Line(x1 - temp, y1 + temp, x1 + temp, y1 - temp, myGraphics));
		lists.add(new Line(x1 + temp, y1 + temp, x1 - temp, y1 - temp, myGraphics));
	}
}
