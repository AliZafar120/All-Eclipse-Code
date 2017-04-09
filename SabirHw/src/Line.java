

import java.awt.Graphics;

public class Line implements IShape{
	private Graphics myGraphics;
	private int x1, y1, x2, y2;
	
	public Line(int x1, int y1, int x2, int y2, Graphics g){
		this.myGraphics = g;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		myGraphics.drawLine(x1, y1, x2, y2);
	}
}
