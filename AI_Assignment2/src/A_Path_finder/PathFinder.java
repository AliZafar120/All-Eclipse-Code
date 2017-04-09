package A_Path_finder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PathFinder {

	public static void main(String[] args) throws IOException {
		
		
		ArrayList<Block> obstacles= new ArrayList<Block>();
		obstacles.add(new Block(2,4));
		obstacles.add(new Block(2,5));
		obstacles.add(new Block(3,5));

		Board b= new Board(4, 7);
		b.SetBoardStart(4, 2);
		b.SetBoardEnd(2, 7);
		b.SetObstacleBlocks(obstacles);
		b.Solve_Board();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	int rows,columns;
		int[][] values;
		int start_X,start_Y,goal_X,goal_Y;
		Block start,end;
		ArrayList<Block> obstacles= new ArrayList<Block>();
	
		
		//reading from file
		InputStream fileStream= new FileInputStream(new File("E:\\Eclipse\\workspace\\AI_Assignment2\\src\\A_Path_finder\\input.txt"));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		Scanner scanner;
		inputLine=buffer.readLine();
		scanner = new Scanner(inputLine);
		//getting rows and columns
		rows= Integer.parseInt(scanner.next());
		columns= Integer.parseInt(scanner.next());
		values= new int[rows+1][columns+1];
		
		
		//getting start and end
		inputLine=buffer.readLine();
		scanner = new Scanner(inputLine);
		start= new Block(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
		end=  new Block(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
		
		inputLine=buffer.readLine();
		scanner = new Scanner(inputLine);
		while(scanner.hasNext()){
			obstacles.add(new Block(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next())));
		}
		*/
		
		
		
		
		
	}
	
}
