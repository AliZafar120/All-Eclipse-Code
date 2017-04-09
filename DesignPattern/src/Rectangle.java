import java.awt.Graphics;


public class Rectangle extends CompositeShape{
	private int x1,y1,x2,y2,x3,y3,x4,y4;
	private Graphics g;
	
	public Rectangle(int x1,int y1,int width,int height,Graphics g) {
		/*
		 * drawing rectangle of different height and width
		 * 
		 */
		
		this.x1=x1;
		this.y1=y1;
		
		this.x2=x1+width;
		this.y2=y1;
		
		this.x3=x1;
		this.y3=this.y1-height;
		
		this.x4=x2;
		this.y4=this.y2-height;
		this.g=g;
		buildShape();
		
	}
	
	
	
	
	public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4,
			int y4, Graphics g) {


		/*
		 * drawing rectangle given 4 different points
		 * 
		 */
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x4;
		this.y3 = y4;
		this.x4 = x3;
		this.y4 = y3;
		this.g = g;
		buildShape();
	}




	@Override
	public void buildShape() {
		// TODO Auto-generated method stub
	shapes.add(new Line(x1, y1, x2, y2, g));
	shapes.add(new Line(x1, y1, x3, y3, g));
	shapes.add(new Line(x2, y2, x4, y4, g));
	shapes.add(new Line(x3, y3, x4, y4, g));
	
	}
	

}
