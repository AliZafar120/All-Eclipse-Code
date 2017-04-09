package A_Path_finder;

import java.util.ArrayList;
import java.util.Currency;
import java.util.PriorityQueue;

public class Board {

	Block start,end;
	int totalRows,totalColumns;
	Block[][] board_Blocks;
	public Board(int rows,int columns) {
		// TODO Auto-generated constructor stub
		totalRows=rows;
		totalColumns=columns;
		
		board_Blocks= new Block[rows+1][columns+1];
		for(int i=1;i<=rows;i++){
			
			for(int j=1;j<=columns;j++){
				board_Blocks[i][j]=new Block(i,j);
			}
			
		}
	
	}//end constructor
	
	
	public void Solve_Board(){
		
		SetHeuristicValues();
		
		PriorityQueue<Block>openList= new PriorityQueue<Block>(totalColumns*totalRows,new BlockComaparator());
		//ArrayList<Block>openList= new ArrayList<Block>();
		
		ArrayList<Block> closeList= new ArrayList<Block>();
		start.g_value=0;
		
		openList.add(start);
		Block current=openList.poll();
		
		
		while(!current.is_goal){
			
			ArrayList<Block> currentNeighbor=new ArrayList<Block>();
			
			//up
			if(current.x>1){
				if((openList.contains(board_Blocks[current.x-1][current.y]) && current.g_value+10<board_Blocks[current.x-1][current.y].g_value) || (!board_Blocks[current.x-1][current.y].is_obstacle && !openList.contains(board_Blocks[current.x-1][current.y]) && !closeList.contains(board_Blocks[current.x-1][current.y]))){
				
					board_Blocks[current.x-1][current.y].g_value=current.g_value+10;//up
					board_Blocks[current.x-1][current.y].CalculateFValue();
					board_Blocks[current.x-1][current.y].parent=current;
					openList.add(board_Blocks[current.x-1][current.y]);
					currentNeighbor.add(board_Blocks[current.x-1][current.y]);
					
				}
			}
			
			//down
			
			if(current.x+1<=totalRows){
				if((openList.contains(board_Blocks[current.x+1][current.y]) && current.g_value+10<board_Blocks[current.x+1][current.y].g_value) || (!board_Blocks[current.x+1][current.y].is_obstacle && !openList.contains(board_Blocks[current.x+1][current.y]) && !closeList.contains(board_Blocks[current.x+1][current.y]))){
					board_Blocks[current.x+1][current.y].g_value=current.g_value+10;//down
					board_Blocks[current.x+1][current.y].CalculateFValue();
					board_Blocks[current.x+1][current.y].parent=current;
					openList.add(board_Blocks[current.x+1][current.y]);
					currentNeighbor.add(board_Blocks[current.x+1][current.y]);
				}
			}
			
			//left
			
			if(current.y>1){
				if((openList.contains(board_Blocks[current.x][current.y-1]) && current.g_value+10<board_Blocks[current.x][current.y-1].g_value) || (!board_Blocks[current.x][current.y-1].is_obstacle && !openList.contains(board_Blocks[current.x][current.y-1]) && !closeList.contains(board_Blocks[current.x][current.y-1])))
				{
					board_Blocks[current.x][current.y-1].g_value=current.g_value+10;//left
					board_Blocks[current.x][current.y-1].CalculateFValue();
					board_Blocks[current.x][current.y-1].parent=current;
					openList.add(board_Blocks[current.x][current.y-1]);
					currentNeighbor.add(board_Blocks[current.x][current.y-1]);
				}
			}
			
			//right
			if(current.y+1<=totalColumns){
				if((openList.contains(board_Blocks[current.x][current.y+1]) && current.g_value+10<board_Blocks[current.x][current.y+1].g_value) || (!board_Blocks[current.x][current.y+1].is_obstacle && !openList.contains(board_Blocks[current.x][current.y+1]) && !closeList.contains(board_Blocks[current.x][current.y+1]))){
					board_Blocks[current.x][current.y+1].g_value=current.g_value+10;//right
					board_Blocks[current.x][current.y+1].CalculateFValue();
					board_Blocks[current.x][current.y+1].parent=current;
					openList.add(board_Blocks[current.x][current.y+1]);
					currentNeighbor.add(board_Blocks[current.x][current.y+1]);
				}
			}
			
			//diagonal left
			if(current.x>1){
				if((current.y>1) && ((openList.contains(board_Blocks[current.x-1][current.y-1]) && current.g_value+14<board_Blocks[current.x-1][current.y-1].g_value)||( !board_Blocks[current.x-1][current.y-1].is_obstacle && !openList.contains(board_Blocks[current.x-1][current.y-1]) && !closeList.contains(board_Blocks[current.x-1][current.y-1])))){
					
				board_Blocks[current.x-1][current.y-1].g_value=current.g_value+14;//top left
				board_Blocks[current.x-1][current.y-1].CalculateFValue();
				board_Blocks[current.x-1][current.y-1].parent=current;
				openList.add(board_Blocks[current.x-1][current.y-1]);
				currentNeighbor.add(board_Blocks[current.x-1][current.y-1]);
				
				}
				
				if((current.y+1<=totalColumns) &&((openList.contains(board_Blocks[current.x-1][current.y+1]) && current.g_value+14<board_Blocks[current.x-1][current.y+1].g_value) || ( !board_Blocks[current.x-1][current.y+1].is_obstacle && !openList.contains(board_Blocks[current.x-1][current.y+1]) && !closeList.contains(board_Blocks[current.x-1][current.y+1])))){
					board_Blocks[current.x-1][current.y+1].g_value=current.g_value+14;//down left
					board_Blocks[current.x-1][current.y+1].CalculateFValue();
					board_Blocks[current.x-1][current.y+1].parent=current;
					openList.add(board_Blocks[current.x-1][current.y+1]);
					currentNeighbor.add(board_Blocks[current.x-1][current.y+1]);
				}
			}
			
			
			//diagonal right
			if(current.x+1<=totalRows){
				
				if((current.y>1) && ((openList.contains(board_Blocks[current.x+1][current.y-1]) && current.g_value+14<board_Blocks[current.x+1][current.y-1].g_value) || (!board_Blocks[current.x+1][current.y-1].is_obstacle && !openList.contains(board_Blocks[current.x+1][current.y-1]) && !closeList.contains(board_Blocks[current.x+1][current.y-1])))){
					board_Blocks[current.x+1][current.y-1].g_value=current.g_value+14;//top right
					board_Blocks[current.x+1][current.y-1].CalculateFValue();
					board_Blocks[current.x+1][current.y-1].parent=current;
					openList.add(board_Blocks[current.x+1][current.y-1]);
					currentNeighbor.add(board_Blocks[current.x+1][current.y-1]);
				
				}
				
				
				
					if((current.y+1<=totalColumns) && ((openList.contains(board_Blocks[current.x+1][current.y+1]) && current.g_value+14<board_Blocks[current.x+1][current.y+1].g_value) || (!board_Blocks[current.x+1][current.y+1].is_obstacle && !openList.contains(board_Blocks[current.x+1][current.y+1]) && !closeList.contains(board_Blocks[current.x+1][current.y+1])))){
						board_Blocks[current.x+1][current.y+1].g_value=current.g_value+14;//down right
						board_Blocks[current.x+1][current.y+1].CalculateFValue();
						board_Blocks[current.x+1][current.y+1].parent=current;
						openList.add(board_Blocks[current.x+1][current.y+1]);
						currentNeighbor.add(board_Blocks[current.x+1][current.y+1]);
					}
				
			}
			
			
			
			closeList.add(current);
			current=openList.poll();
			
		}
		Mazeprint();
		//PathPrinter(current);
		SolvedMazePrint();
		
	}
	
	

	public ArrayList<Integer> getSolvedPath(){
		
		ArrayList<Integer> solved= new ArrayList<Integer>();
		Block current=end;
		while(current!=null){
			solved.add(totalColumns*(current.x-1)+current.y);
			current=current.parent;
		}
		return solved;
	}
	
	
	
	
	public void PathPrinter(Block current){
		while(!current.is_start){
			System.out.println("X :"+current.x+"---- Y:"+current.y);
			current=current.parent;
		}
		System.out.println("X :"+current.x+"---- Y:"+current.y);
		
	}
	
	public void SolvedMazePrint(){
		ArrayList<Block> solved=new ArrayList<Block>();
		Block current= end;
		while(!solved.contains(start)){
			solved.add(current.parent);
			current=current.parent;
		}
		
		
		for(int i=1;i<=totalRows;i++){
			for(int j=1;j<=totalColumns;j++){
				if(solved.contains(board_Blocks[i][j]))System.out.printf("-");
				else if(board_Blocks[i][j].is_obstacle)System.out.printf("#");
				else if(board_Blocks[i][j].is_start)System.out.printf("S");
				else if(board_Blocks[i][j].is_goal)System.out.printf("G");
				else System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void Mazeprint(){
		
		for(int i=1;i<=totalRows;i++){
			for(int j=1;j<=totalColumns;j++){
				if(board_Blocks[i][j].is_obstacle)System.out.printf("#");
				else if(board_Blocks[i][j].is_start)System.out.printf("S");
				else if(board_Blocks[i][j].is_goal)System.out.printf("G");
				else System.out.printf("*");
			}
			System.out.println();
		}
		
	}
	
	
	
	public void SetHeuristicValues(){
		
		for(int i=1;i<=totalRows;i++){
			
			for(int j=1;j<=totalColumns;j++){
				
				if(!board_Blocks[i][j].is_obstacle && !!board_Blocks[i][j].is_goal){
					board_Blocks[i][j].h_value=Math.abs(end.x-board_Blocks[i][j].x)+Math.abs(end.y-board_Blocks[i][j].y);
					
				}
			}
		}
			
	}
	
	
	
	
	
	
	
	
	
	//setting obstacles
	public void SetObstacleBlocks(ArrayList<Block> obstacles){
		for(int i=0;i<obstacles.size();i++){
			board_Blocks[obstacles.get(i).x][obstacles.get(i).y].is_obstacle=true;
		}
		
	}
	
	
	//set start 
	public void SetBoardStart(int x,int y){
		board_Blocks[x][y].is_start=true;
		start=board_Blocks[x][y];
		
	}
	
	
	
	//set end
	public void SetBoardEnd(int x,int y){
		board_Blocks[x][y].is_goal=true;
		end=board_Blocks[x][y];
	}
	
}
