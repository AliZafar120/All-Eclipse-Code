package CompositePattern;

public class Square extends Shape {
	
	@SuppressWarnings("unused")
	private int x1,x2,x3,x4,y1,y2,y3,y4,height,width;
	
	public Square(int x1,int y1, int height, int width)
	{
		this.x1=x1;
		this.y1=y1;
		
		this.height = height;
		this.width = width;
		
		DrawShape();
	}

	@Override
	public void BuildShape() {
		list.add(new Line(x1,y1,x1+width,y1));
		list.add(new Line(x1+width,y1,x1+width,y1+height));
		list.add(new Line(x1+width,y1+height,x1,y1+height));
		list.add(new Line(x1,y1,x1,y1+height));
	}

}
