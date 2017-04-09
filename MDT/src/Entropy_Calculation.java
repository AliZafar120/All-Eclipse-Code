import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Entropy_Calculation {

	static ArrayList<ArrayList<Double>> allinInt;
	static HashSet<Double> unique_elements;
	static int sizeoftotal;
	
	public Entropy_Calculation(ArrayList<ArrayList<Double>> a) {
		// TODO Auto-generated constructor stub
		allinInt=a;
		sizeoftotal=a.size();
	}
	
	public HashMap<Integer, Integer> returnMaxGain(Double rootgain,int a){
		
		HashMap<Integer, Double> bestMaxgain= new HashMap<Integer, Double>();
		HashMap<Integer, Integer> bestMaxgain_of_a_column= new HashMap<Integer, Integer>();
		ArrayList<HashMap<Integer, V>> items_in_each= new ArrayList<ArrayList<Integer>>();
		Double current;
		
		for(int i=0;i<sizeoftotal;i++){
			current=allinInt.get(a).get(i);
			for(int j=0;j<sizeoftotal;j++){
				if(i==j) continue;
				if(allinInt.get(a).get(j)>current)
			}
			
		}
		
		
		
		return null;
	
	
		
		
		
		
	}
	
	
	public double calculate_entropy(double value){
		
		return -value*Math.log(value)/Math.log(2);
		
	}
	
	
	public static double returnRootGain(ArrayList<Double> a ){
		
		HashSet<Double> b= new HashSet<Double>(a);
		int size=b.size(),count;
		unique_elements=b;
		
		Double cnt,gain=0.0;
		while(b.iterator().hasNext()){
			cnt=(double)Collections.frequency(a, b.iterator().next());
			gain-=(cnt/size)*Math.log(cnt/size)/Math.log(2);
			
			
		}
		
		return gain;
		
	}
	
	
}
