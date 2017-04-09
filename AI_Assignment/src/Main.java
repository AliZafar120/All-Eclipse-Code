import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Breadth_First_Search bfs= new Breadth_First_Search("E:\\Eclipse\\workspace\\AI_Assignment\\src\\input.txt", "A", "L");
	/*	bfs.getInputFromFile();
*/		bfs.BuildGraph();
		bfs.SearchGoal();
	}

}
