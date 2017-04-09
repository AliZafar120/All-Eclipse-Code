package Cases;

import java.util.ArrayList;

public class Case9 {
	
	



	public double maxgainValue=-5456456.0;
	
	
	public void resolve(ArrayList<Data> data,int classnum,	boolean thresoldOpt[],double calcGainValue){
		int dataSize = data.size();
		int numberOfClass = classnum;
		if(numberOfClass < 2) return;
		boolean nonLeaf = true;
		double nodeEntropy = calcNodeEntropy(data);
		double maxGainValue = -5456456.0;
		int dataOpt = data.get(0).size;
		
		for(int i = 1; i < dataOpt; i++){
			if(thresoldOpt[i]) continue;
			double val = calcGainValue;
			if(val > maxGainValue){
				maxGainValue = val;
			 	int threshold = i;
			}
		}
		System.out.println(maxGainValue);
		maxgainValue=maxGainValue;
		divideInSets();
	}

	private int totalClasses(ArrayList<Data> data2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double calcNodeEntropy(ArrayList<Data> data2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double calcGainValue(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void divideInSets() {
		// TODO Auto-generated method stub
		
	}

public static class Data {
	
	String className;
	int size;
	int data[];
	
	public Data(String line) {
		// TODO Auto-generated constructor stub
		String arr[] = line.split(",");
		size = arr.length;
		data = new int[size];
		className = arr[0];
		for(int i=1; i<size; i++){
			data[i] = Integer.parseInt(arr[i]);
		}
	}
}


}
