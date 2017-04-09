import java.util.ArrayList;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		
		FileReader fileReader=new FileReader();
		ArrayList<ArrayList<Double>> data= fileReader.getRecords();
		Tree tree=new Tree(data);
		Double arr[]={5.0,5.0,5.0,5.0};
		ArrayList<Double> testData=new ArrayList<Double>(Arrays.asList(arr));
		tree.traverse_tree(testData);
		
		/*
		 * 5,5,4,1,1
5,5,4,2,1
5,5,4,3,1
5,5,4,4,1
5,5,4,5,1
5,5,5,1,1
5,5,5,2,1
5,5,5,3,1
5,5,5,4,1
5,5,5,5,0

		 */
	}
}
