package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape implements Ishape{

	List<Ishape> list = new ArrayList<Ishape>();
	
	public abstract void BuildShape();
	
	
	@Override
	public void DrawShape() {
	
		BuildShape();
		
		for (Ishape ishape : list) {
			ishape.DrawShape();
		}
	}

}
