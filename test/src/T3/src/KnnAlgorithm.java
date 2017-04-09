package T3.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class KnnAlgorithm {
	public String trainFilePath="E:\\Eclipse\\workspace\\test\\src\\T3\\src\\train.txt";
	public String testFilePath="E:\\Eclipse\\workspace\\test\\src\\T3\\src\\test.txt";
	public int value_of_K;
	public ArrayList<FlowerFeatures> trainData= new ArrayList<FlowerFeatures>();
	public ArrayList<FlowerFeatures> testData= new ArrayList<FlowerFeatures>();
	public HashMap<String,Integer> categoryValue;
	public String selectedCategory;
	public double accuracy=0.0;
	String [][] originalAndObtained;
	
	public void setValueOfK(int k){
		value_of_K=k;
	}
	
	public void knnAlgorithmImplement(int k,FlowerFeatures singletestData){
		
		
		setValueOfK(k);
		calculateDistanceFromTrainData(singletestData);
		sortEuclideanDistance();
		getherCategoriesValue();
		categoryBasedOnMajority();
		
	}
	


	public void calculateDistanceFromTrainData(FlowerFeatures singleTestData){
		
		for(int i=0;i<trainData.size();i++){
		trainData.get(i).euclidean_distance=Math.sqrt(
				Math.pow((trainData.get(i).Petal_length-singleTestData.Petal_length), 2)+
				Math.pow((trainData.get(i).Petal_width-singleTestData.Petal_width), 2)+
				Math.pow((trainData.get(i).Sepal_length-singleTestData.Sepal_length), 2)+
				Math.pow((trainData.get(i).Sepal_width-singleTestData.Sepal_width), 2)
				);	
		}
	
	
	}
	
	public void sortEuclideanDistance(){
		
		Collections.sort(trainData,new EuclideanDistanceComparator());
		
	}
	
	public void getherCategoriesValue(){
		categoryValue= new HashMap<String,Integer>();
		for(int i=0;i<value_of_K;i++){
		if(!categoryValue.keySet().contains(trainData.get(i).Species_name))categoryValue.put(trainData.get(i).Species_name,1);
		else 
		{
			categoryValue.put(trainData.get(i).Species_name,categoryValue.get(trainData.get(i).Species_name)+1);
		
		}
		}
		
	}
	
	
	public void categoryBasedOnMajority(){
		int currentMaxValue=0;
		for(String category:categoryValue.keySet()){
			if(categoryValue.get(category)>currentMaxValue){
				selectedCategory=category;
				currentMaxValue=categoryValue.get(category);
			}
		}
		
	}
	
	

	public void testingAllTestData(int value_of_K){
		
		for(int i=0;i<testData.size();i++){
			
			knnAlgorithmImplement(value_of_K, testData.get(i));
			originalAndObtained[i][0]=testData.get(i).Species_name;
			originalAndObtained[i][1]=selectedCategory;
			System.out.println("For Test Data "+i+ ": Orginal-> "+originalAndObtained[i][0]+" Obtained-> "+originalAndObtained[i][1]);
			
		}
		
		
		
	}
	
	
	
	
	public void readTrainFile() throws IOException{
		InputStream fileStream= new FileInputStream(new File(trainFilePath));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		
		while ((inputLine=buffer.readLine())!=null) {
			
			String []tokens=inputLine.split("\t");
		//	nodeWeights.put(tokens[0], Integer.parseInt(tokens[1]));
			FlowerFeatures singleTrainData= new FlowerFeatures(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), tokens[5]);
			trainData.add(singleTrainData);
		
		}
		System.out.println(trainData.size());
	}
	
	
	public void readTestFile() throws IOException{
		InputStream fileStream= new FileInputStream(new File(testFilePath));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		
		while ((inputLine=buffer.readLine())!=null) {
			
			String []tokens=inputLine.split("\t");
		//	nodeWeights.put(tokens[0], Integer.parseInt(tokens[1]));
			FlowerFeatures singleTrainData= new FlowerFeatures(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), tokens[5]);
			testData.add(singleTrainData);
		
		}
		originalAndObtained= new String[testData.size()][2];
		System.out.println(testData.size());
	}
	
	public void accuracyCalculation(){
		int correct=0;
		
		for(int i=0;i<testData.size();i++){
			if(originalAndObtained[i][0].equalsIgnoreCase(originalAndObtained[i][1])) correct++;
		}
		accuracy=(double)correct*100/(double)testData.size();
		System.out.printf("********************************Accuracy: %.2f ***************************", accuracy);
		
	}
	
	public void accuracyForAllOdd_K_Values() throws IOException{
		FileWriter fileWriter = new FileWriter(new File("E:\\Eclipse\\workspace\\test\\src\\T3\\src\\K_Value_Accuracy.txt"));
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    PrintWriter printToFile = new PrintWriter(bufferedWriter);
	    //printToFile.printf("k Accuracy\n");
		
		for(int i=1;i<trainData.size();i=i+2){
			testingAllTestData(i);
			accuracyCalculation();
		    printToFile.printf("For K value %d: The accuracy is %.2f\n",i,accuracy);
		    //printToFile.printf("%d %.2f\n",i,accuracy);
			
		}
		
			printToFile.close();
		    bufferedWriter.close();
		    fileWriter.close();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class FlowerFeatures{

		public int Species_no;
		public double Petal_width;
		public double Petal_length;
		public double Sepal_width;
		public double Sepal_length;
		public String Species_name;
		public double euclidean_distance=0.0;
		
		
		
		public  FlowerFeatures(int species_no, double petal_width, double petal_length, double sepal_width,
				double sepal_length, String species_name) {
			super();
			Species_no = species_no;
			Petal_width = petal_width;
			Petal_length = petal_length;
			Sepal_width = sepal_width;
			Sepal_length = sepal_length;
			Species_name = species_name;
		}
		
		
		
	}
	
	public class EuclideanDistanceComparator implements Comparator<FlowerFeatures> {

		@Override
		public int compare(FlowerFeatures feature1, FlowerFeatures feature2) {
			// TODO Auto-generated method stub
			if(feature1.euclidean_distance>feature2.euclidean_distance) return 1;
			else if (feature1.euclidean_distance<feature2.euclidean_distance) return -1;
			else return 0;
		}
	}
	
}
