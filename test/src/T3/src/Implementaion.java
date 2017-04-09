package T3.src;

import java.io.IOException;

public class Implementaion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		KnnAlgorithm algorithm= new KnnAlgorithm();
		algorithm.readTrainFile();
		algorithm.readTestFile();
		//algorithm.testingAllTestData(5);
		//algorithm.accuracyCalculation();
		algorithm.accuracyForAllOdd_K_Values();

	}

}
