import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr= new FileReader("E:\\Eclipse\\workspace\\MyDecisionTree\\src\\input.txt");
		ArrayList<ArrayList<Double>> inputs=fr.get_processed_input();
		Tree tree= new Tree(inputs);
		Double arr[]={5.0,5.0,5.0,5.0};
		ArrayList<Double> testData=new ArrayList<Double>(Arrays.asList(arr));
		tree.Traverse_Tree(testData);
		
	}

}
