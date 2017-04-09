import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	FileInput a = new FileInput();
	a.read();
	ArrayList<ArrayList<Double>>AllInColumns=a.returnAllinColumns();

	Entropy_Calculation entropy= new Entropy_Calculation(AllInColumns);
	System.out.println("The entropy is "+entropy.returnRootGain());

	System.out.println(entropy.getMaxEntropy());

	
	
	}

}
