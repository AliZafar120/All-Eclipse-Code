package CompositePattern;

public class Line implements Ishape {

	private int x1,y1,x2,y2;
	
	public  Line(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		
	}
	
	@Override
	public void DrawShape() {
		Canvas.G.drawLine(x1, y1, x2, y2);
	}

	

}
