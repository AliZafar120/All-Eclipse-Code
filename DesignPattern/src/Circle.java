import java.awt.Graphics;

public class Circle implements IShape{

	private int height;
	private int width=0;
	private Graphics g;
	private int x;
	private int y;
	public Circle(int x,int y,int radius,Graphics g) {
		/*
		 * for drawing circle with radius and center
		 */
	this.x=x;
	this.y=y;
	this.height=radius;
	this.g=g;
	
	}
	
	public Circle(int x,int y,int height,int width,Graphics g) {
		/*
		 * for drawing oval shapes
		 */
	this.x=x;
	this.y=y;
	this.height=height;
	this.width=width;
	this.g=g;
	
	}
	
	
	@Override
	public void drawshape() {
		/*
		 * construction of the circle
		 */
		if(width==0)g.drawOval(x, y, height, height);
		else g.drawOval(x, y, width, height);
	}

}
