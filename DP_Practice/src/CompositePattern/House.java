package CompositePattern;

public class House extends Shape{

	private int x1,y1,height,width;
	
	public House (int x1,int y1, int height, int width) {
		
		this.x1=x1;
		this.y1=y1;
		
		this.height = height;
		this.width = width;
		
		DrawShape();
		
	}

	@Override
	public void BuildShape() 
	{
		list.add(new Square(x1,y1,height,width));
		list.add(new Square(x1+width/3,y1+height/3,(height/3)*2,(width/3)));
		list.add(new Line(x1+width/3+(width/3)/2, y1+height/3,x1+width/3+(width/3)/2, y1+height));
		list.add(new Triangle(x1-10, y1, x1+10+width, y1, x1+width/2, y1-height/2));
		
	}

}
