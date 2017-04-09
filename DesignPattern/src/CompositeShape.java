import java.util.ArrayList;
import java.util.List;




public class CompositeShape implements IShape{

	ArrayList<IShape>  shapes = new ArrayList<IShape>();
	
	/*
	 * list of shapes holding the required shapes to draw composite shape(non-Javadoc)
	 */
	
	@Override
	public void drawshape() {
		
		/*
		 * Drawing each shape in the list common to all composite shapes
		 */
				
		
		for(IShape a: shapes){
			a.drawshape();
		}
		
	}
	
	
	public void buildShape(){
		
		
	}

}
