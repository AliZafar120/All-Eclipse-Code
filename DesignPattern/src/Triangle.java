import java.awt.Graphics;


public class Triangle extends CompositeShape{

	private int x1,x2,x3,y1,y2,y3;
	
	Graphics g;
	
	
	
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3,Graphics g) {
		/*
		 * drawing triangle with 3 points
		 */
		
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.g=g;
		buildShape();
	}

	public Triangle(int x1, int y1, int x2, int y2,Graphics g) {
		// TODO Auto-generated constructor stub
		/*
		 * drawing triangle with 2 points
		 */
		
		
		this.x1 = x1;
		this.x2 = x2;
		this.x3=this.x1+Math.abs(this.x1-this.x2)/2;
		this.y1 = y1;
		this.y2 = y2;
		this.y3=this.y1-Math.abs(this.x1-this.x2)/2;
		this.g=g;
		buildShape();
		
		
	}


	@Override
	public void buildShape() {
		// TODO Auto-generated method stub
		shapes.add(new Line(x1, y1, x2, y2, g));
		shapes.add(new Line(x1, y1, x3, y3, g));
		shapes.add(new Line(x2, y2, x3, y3, g));
		
		
	
	}
	
	
	@Override
	public void drawshape() {
		// TODO Auto-generated method stub
		for(IShape a: shapes){
			a.drawshape();
		}
	
	}
	
}
