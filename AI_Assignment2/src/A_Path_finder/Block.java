package A_Path_finder;

public class Block {
	int x,y;
	Block parent;
	int f_value;
	int g_value;
	int h_value;
	boolean is_goal;
	boolean is_start;
	boolean is_obstacle;
	
	public Block() {
		// TODO Auto-generated constructor stub
		f_value=0;
		g_value=0;
		h_value=0;
		is_start=false;
		is_goal=false;
		is_obstacle=false;
	}
	
	public Block(int x,int y) {
		// TODO Auto-generated constructor stub
	
	this.x=x;
	this.y=y;
	
	
	f_value=0;
	g_value=0;
	h_value=0;
	is_start=false;
	is_goal=false;
	is_obstacle=false;
	
	}
	

	
	public int GetFValue(){
		CalculateFValue();
		return f_value;
	}
	
	public void CalculateFValue(){
		f_value=g_value+h_value;
	}

	public boolean equals(Block block2) {
	    return block2 instanceof Block && x==(((Block)block2).x) && y==(((Block)block2).y);
	}
	

}
