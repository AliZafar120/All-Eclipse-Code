package Cases;

import java.util.ArrayList;



public class Case3 {

	public String final_result="";
	public void SolvedMazePrint(Block start,Block end,int totalRows,int totalColumns,Block board_Blocks[][]){
		ArrayList<Block> solved= new ArrayList<Case3.Block>();
		final_result="";
		Block current= end;
		while(!solved.contains(start)){
			solved.add(current.parent);
			current=current.parent;
		}
		
		
		for(int i=1;i<=totalRows;i++){
			for(int j=1;j<=totalColumns;j++){
				if(solved.contains(board_Blocks[i][j])){System.out.printf("-");final_result+="-";}
				else if(board_Blocks[i][j].is_obstacle){System.out.printf("#");final_result+="#";}
				else if(board_Blocks[i][j].is_start){System.out.printf("S");final_result+="S";}
				else if(board_Blocks[i][j].is_goal){System.out.printf("G");final_result+="G";}
				else {System.out.printf("*");final_result+="*";}
			}
			System.out.println();
			final_result+=" new_line ";
		}
	}
	
	public static class Block {
		public int x,y;
		public Block parent;
		public int f_value;
		public int g_value;
		public int h_value;
		public boolean is_goal;
		public boolean is_start;
		public boolean is_obstacle;
		
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

}
