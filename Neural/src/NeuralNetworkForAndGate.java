import java.util.ArrayList;


public class NeuralNetworkForAndGate {

	static Double weight1;
	static Double weight2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		setInitialWeight();
		trainUptoNoErrors();
	
		

	}
	
	public static void trainUptoNoErrors(){
		int Errors=0;
		do{
			Errors=trainNeuralNetwork();
			//System.out.println(Errors);
			
		}while(Errors>0);
	}
	
	
	public static Double[][] getTrainingData(){
	
		Double[][] input = {
								{0.0,0.0,0.0},
								{0.0,1.0,0.0},
								{1.0,0.0,0.0},
								{1.0,1.0,1.0},
							};
		
		return input;
	}
	
	
	public static void setInitialWeight(){
		weight1=0.3;
		weight2=-0.1;
	}
	
	
	public static int trainNeuralNetwork(){
		
		Double[][] inputArray=getTrainingData();
		
		Double input1;
		Double input2;
		Double Threshold=0.2;
		Double Learning_rate=0.1;
		
		Double ActualOutput;
		Double CalculatedOutput;
		Double Error;
		int ErrorCount=0;
		
		for(int i =0;i<4;i++){
			input1=inputArray[i][0];
			input2=inputArray[i][1];
			ActualOutput=inputArray[i][2];
			
			System.out.printf("in1: "+input1+" in2: "+input2 +" w1: "+weight1+" w2: "+weight2+ " Actual: "+ActualOutput);
			
			Double Output=input1*weight1+input2*weight2;
			
			if(Threshold>Output) CalculatedOutput=0.0;
			else CalculatedOutput=1.0;
			
			Error=ActualOutput-CalculatedOutput;
			
			if(CalculatedOutput.doubleValue()==ActualOutput.doubleValue()){
				System.out.printf(" Calculated: "+CalculatedOutput+ " Error: "+Error+ " Fw1: "+weight1+" Fw2: "+weight2);
				System.out.println();
			}
			else{
				weight1=Math.round((weight1+Learning_rate*Error*input1)*10.0)/10.0;
				weight2=Math.round((weight2+Learning_rate*Error*input2)*10.0)/10.0;
			//	weight1=weight1+Learning_rate*Error*input1;
				//weight2=weight2+Learning_rate*Error*input2;
	
				ErrorCount++;
				System.out.printf(" Calculated: "+CalculatedOutput+ " Error: "+Error+ " Fw1: "+weight1+" Fw2: "+weight2);
				System.out.println();
			}
			
		}
		
		System.out.println("***********Total Errors Found :"+ErrorCount+" ******************");
		
		return ErrorCount;
		
	}

}
