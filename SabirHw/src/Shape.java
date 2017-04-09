

import java.util.ArrayList;
import java.util.List;

public abstract class Shape implements IShape{
	List<IShape> lists = new ArrayList<>();
	@Override
	public void drawShape(){
		for(IShape shape: lists) 
			shape.drawShape();
	}
	
	public abstract void buildShape();
}
