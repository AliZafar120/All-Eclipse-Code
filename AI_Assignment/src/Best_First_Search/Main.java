package Best_First_Search;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Best_First_Search bfs = new Best_First_Search("Dhaka", "Kaligonj","E:\\Eclipse\\workspace\\AI_Assignment\\src\\BestFSData.txt" , "E:\\Eclipse\\workspace\\AI_Assignment\\src\\BestFSweight.txt");
		bfs.BuildGraph();
		bfs.get_goal();
		
	

	}

}
