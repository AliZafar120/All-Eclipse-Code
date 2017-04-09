package CompositePattern;

public class Tree extends Shape{

	private int x,y,height;
	
	public Tree(int x, int y,int height)
	{
		this.x = x;
		this.y = y;
		this.height = height;
		
		DrawShape();
	}
	
	@Override
	public void BuildShape() 
	{
		list.add(new Line(x, y, x, y+height));
		list.add(new Line(x-(height/4), y+(height/4), x+(height/4), y-(height/4)));
		list.add(new Line(x+(height/4), y+(height/4), x-(height/4), y-(height/4)));
		list.add(new Line(x, y, x, y-(height/3)));
		list.add(new Line(x-(height/4), y, x+(height/4), y));
		list.add(new Line(x-(height/15), y+height, x+(height/15), y+height));
		
	}

}
