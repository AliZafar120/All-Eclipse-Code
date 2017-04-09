
import java.awt.Graphics;

public class House extends Shape{
	private Graphics myGraphics;
	int x1, y1, x2, y2, height;
	public House(int x1, int y1, int x2, int y2, int height, Graphics g) {
		/*
	     * It takes top left point and bottom right points of the house rectangle and the height of the roof
	     * 
	     * */
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.height = height;
		myGraphics = g;
		buildShape();
	}
	
	@Override
	public void buildShape() {
		// TODO Auto-generated method stub
		new Rectangle(x1, y1, x2, y2, myGraphics).drawShape();
		int temp = Math.abs(x1 - x2)/2;
		int tempY = Math.abs(y1 - y2)/2;
		new Triangle(x1, y1, x2, y1, x1 + temp, y1 - height, myGraphics).drawShape();
		new Rectangle((int)(x1 + temp*.7), y1 + tempY, (int)(x1 + temp*1.3), y2, myGraphics).drawShape();
	}

}
