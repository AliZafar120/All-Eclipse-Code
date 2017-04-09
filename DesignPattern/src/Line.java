import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.RepaintManager;


public class Line implements IShape {
	
	private double x1,y1,x2,y2;
	private final Graphics2D g; 

	public Line(int x1,int y1,int x2,int y2,Graphics g) {
		/*
		 * Drawing line with two given points
		 */
		
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.g= (Graphics2D) g;
	}
	
	@Override
	public void drawshape() {
		 g.draw(new Line2D.Double(x1, y1, x2,y2));
		
	}
	
}
