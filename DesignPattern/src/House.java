import java.awt.Graphics;


public class House extends CompositeShape{

private int x1,y1,height,width;
private Graphics g;
	
public House(int x1,int y1,Graphics g) {
	
	/*
	 * drawing house with only a point 
	 */
	this.x1=x1;
	this.y1=y1;
	this.height=60;
	this.width=60;
	this.g= g;
	
	
	buildShape();
	
}


public House(int x1, int y1, int height, int width, Graphics g) {
	
	/*
	 * drawing house of different height and width
	 */
	
	this.x1 = x1;
	this.y1 = y1;
	this.height = height;
	this.width = width;
	this.g = g;
	buildShape();
}

@Override
	public void buildShape() {

	shapes.add(new Rectangle(x1, y1, this.width, this.height, g));	// draws the outer rectangle
	shapes.add(new Rectangle(x1+width/4, y1, width/2, height*3/4, g));//draws the doors
	shapes.add(new Triangle(x1, y1-height, x1+width, y1-height, g));//draws the roof
		
	}


}
