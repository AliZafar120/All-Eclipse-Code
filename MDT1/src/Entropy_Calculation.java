import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Entropy_Calculation {

	static ArrayList<ArrayList<Double>> allinInt;
	static ArrayList<Double> unique_elements;
	static int sizeoftotal;
	static Double rootgain;
	
	public Entropy_Calculation(ArrayList<ArrayList<Double>> a) {
		// TODO Auto-generated constructor stub
		allinInt=a;
		sizeoftotal=a.size();
		
		
		
	}
	
	
	public double getMaxEntropy(){
		
		HashMap<Integer, Integer> res= new HashMap<Integer, Integer>();
		for(int i=1;i<sizeoftotal;i++){
			res=returnMaxGain(i);
		}
		int a=res.keySet().iterator().next();
		return allinInt.get(a).get(res.get(a));
		
	}
	
	public HashMap<Integer, Integer> returnMaxGain(int a){
		
		HashMap<Integer, Integer> bestMaxgain= new HashMap<Integer, Integer>();
		Double bestMax=Double.MIN_VALUE;
		// hashpmap<
		
		/*HashMap<Integer, Integer> bestMaxgain_of_a_column= new HashMap<Integer, Integer>();
		ArrayList<HashMap<Integer,Double>> items_in_each= new ArrayList<HashMap<Integer,Double>>();
		ArrayList<ArrayList<ArrayList<Double>>> separated= new ArrayList<ArrayList<ArrayList<Double>>>();
		*/Double current;
		//get best gain and location
		ArrayList<ArrayList<Integer>> unique_elements_total=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<unique_elements.size();i++) unique_elements_total.add(new ArrayList<Integer>());
/*		ArrayList<ArrayList<Integer>> unique_elements_total_reset=new ArrayList<ArrayList<Integer>>(unique_elements_total);
		
		
		*/
		int total_elements_in_column=allinInt.get(0).size();
		//loop upto all input in a column
		for(int i=0;i<total_elements_in_column;i++){
			//getting a column item
			current=allinInt.get(a).get(i);
			HashMap<Integer, Integer> right_total_unique_elements=new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> left_total_unique_elements=new HashMap<Integer, Integer>();
			//hashmap <position_unique_uniqueset, appearing times> 
					
					
			//comparing the child with other members and gain value determination
			for(int j=0;j<total_elements_in_column;j++){
				if(allinInt.get(a).get(j)>=current)
				{
				if(right_total_unique_elements.get(unique_elements.indexOf(allinInt.get(0).get(j)))!=null) right_total_unique_elements.put(unique_elements.indexOf(allinInt.get(0).get(j)),right_total_unique_elements.get(unique_elements.indexOf(allinInt.get(0).get(j)))+1);
				else right_total_unique_elements.put(unique_elements.indexOf(allinInt.get(0).get(j)),1);
				}
				else{
					if(left_total_unique_elements.get(unique_elements.indexOf(allinInt.get(0).get(j)))!=null) left_total_unique_elements.put(unique_elements.indexOf(allinInt.get(0).get(j)),left_total_unique_elements.get(unique_elements.indexOf(allinInt.get(0).get(j)))+1);
					else left_total_unique_elements.put(unique_elements.indexOf(allinInt.get(0).get(j)),1);
					
					
				}
			}
			
			//now getting total unique elements
			int total_left=0,total_right=0;
			for(int m=0;m<unique_elements.size();m++){
				if(m<right_total_unique_elements.size())total_right+=right_total_unique_elements.get(m);
				if(m<left_total_unique_elements.size())total_left+=left_total_unique_elements.get(m);
			}
			
			Double child_entropy=calculate_child_entropy(total_left, total_right, left_total_unique_elements, right_total_unique_elements, allinInt.get(0).size(), rootgain);
			if(child_entropy>bestMax){
				bestMax=child_entropy;
				System.out.println(child_entropy);
				bestMaxgain.clear();
				bestMaxgain.put(a, i);
				
			}
			
			
		}
		
		
		
		return bestMaxgain;
	
	
		
		
		
		
	}
	
	
	public double calculate_child_entropy(int left,int right,HashMap<Integer, Integer> left_uniques,HashMap<Integer, Integer>right_uniques,int totalparentnum,double parent_gain){
		
		
		Double child_entropy=0.0,child_left_entropy=0.0,child_right_entropy=0.0;
		for(int i=0;i<left_uniques.size() || i<right_uniques.size();i++){
			if(i<left_uniques.size())child_left_entropy+=calculate_entropy(((double)(left_uniques.get(i)))/left);
			if(i<right_uniques.size())child_right_entropy+=calculate_entropy(((double)(right_uniques.get(i)))/right);
			
		}
		
		child_entropy=rootgain-(left/totalparentnum)*child_left_entropy+(right/totalparentnum)*child_right_entropy;
		
	
		return child_entropy;
	}
	
	
	public double calculate_entropy(double value){
		double a=0.0;
		if(value>0)a= -value * (Math.log10(value)/Math.log10(2));
		return a;
	}
	
	
	public static double returnRootGain( ){
		
		TreeSet<Double> b= new TreeSet<Double>(allinInt.get(0));
		int size=b.size(),count;
		unique_elements=new ArrayList<Double>(b);
		Iterator it = b.iterator();
		
		Double cnt,gain=0.0;
		while(it.hasNext()){
			cnt=(double)Collections.frequency(allinInt.get(0), it.next());
			gain-=(cnt/allinInt.get(0).size())*Math.log(cnt/allinInt.get(0).size())/Math.log(2);
			
			
		}
		
		rootgain=gain;
		return gain;
		
	}
	
	
}
