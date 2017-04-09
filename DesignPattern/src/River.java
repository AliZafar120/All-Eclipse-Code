import java.awt.Graphics;


public class River extends CompositeShape {
	
	
	private int x1,y1,x2,y2,x3,y3,height;
	private Graphics g;
	public River(int x1, int y1, int x2, int y2,Graphics g) {
		/*
		 * drawing river with two end points
		 */
		
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3=(int) (Math.abs(this.x1-this.x2))/2+this.x1;
		this.y3=y1-Math.abs(y1-y2)/3;
		this.g= g;
		this.height=80;
		buildShape();
	}

	@Override
	public void buildShape() {
	
		shapes.add(new Line(x1, y1, x3, y3, g));
		shapes.add(new Line(x3, y3, x3, y3+y3*1/4, g));
		shapes.add(new Line(x3,y3+ y3*1/4, x2, y2, g));
		
		shapes.add(new Line(x1, y1+height, x3-50, y3+height, g));
		shapes.add(new Line(x3-50, y3+height, x3-50, y3+y3*1/4+height, g));
		shapes.add(new Line(x3-50,y3+ y3*1/4+height, x2, y2+height, g));
		
	
		
		
	}

	

}
