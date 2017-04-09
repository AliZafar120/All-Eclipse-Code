import java.util.ArrayList;
import java.util.HashMap;

public class EntropyCalculation {
	private ArrayList<ArrayList<Double>> parentdata;
	private ArrayList<Double> unique_elements_of_decision;
	public Double decision;
	public int maxgain_rownum,maxgain_colnum;
	public int row_numbers,column_numbers,unique_elements_number=0;
	public boolean reached_maxgain;
	
	//changed
	private int tree_nums;
	private int depth;
	private ArrayList<Double>leaf_probables;
	private int random_column_considered;
	private int gain_calc_times;
	//changed
	
	public void maxGainCalculation(ArrayList<ArrayList<Double>> allInInput){
		parentdata=allInInput;
		reached_maxgain=false;

		double parentGain=calculateParentgain();
		if(parentGain==0|| depth==9){
			reached_maxgain=true;
			decision=parentdata.get(0).get(column_numbers);
			//do something about leaf probables
			return;
			
		}
		
		Double maxgain=0.0;
		//changed
		ArrayList<Integer> for_random=new ArrayList<Integer>();
		for(int i=0;i<random_column_considered;i++)for_random.add((int)Math.floor(Math.random()*(column_numbers+1)));
		
		
		//changed
		for(int k=0;k<gain_calc_times;k++){
			for(int j=0;j<for_random.size();j++){
			HashMap<Double, Integer> duplicate= new HashMap<Double,Integer>();
				for(int i=0;i<row_numbers;i++){
				if(duplicate.containsKey(parentdata.get(i).get(for_random.get(j))))continue;
				else duplicate.put(parentdata.get(i).get(for_random.get(j)), 1);
				
				
				
				double avg_entropy=calculateChildGain(for_random.get(j), parentdata.get(i).get(for_random.get(j)));
				if(maxgain<(parentGain-avg_entropy)){
					maxgain=parentGain-avg_entropy;
					maxgain_rownum=i;
					maxgain_colnum=for_random.get(j);
					
					}
				
				}
			
			}
		}

	
	}
	
	public double calculateChildGain(int column_num,double value){
		
		
		//column name asbe weight matrix er value theke
		Double left_entropy=0.0,right_entropy=0.0;
		HashMap<Double, Integer> leftElements_and_numbers= new HashMap<Double,Integer>();
		HashMap<Double, Integer> rightElements_and_numbers= new HashMap<Double,Integer>();
		
		
		//akahane column er value onujayi split hoy
		for(int i=0;i<row_numbers;i++){
			if(parentdata.get(i).get(column_num)>value){
				if(rightElements_and_numbers.get(parentdata.get(i).get(column_numbers))==null)
				{
					rightElements_and_numbers.put(parentdata.get(i).get(column_numbers),1);
				}
				else
					rightElements_and_numbers.put(parentdata.get(i).get(column_numbers),rightElements_and_numbers.get(parentdata.get(i).get(column_numbers))+1);
				
			}
			else{
				if(leftElements_and_numbers.get(parentdata.get(i).get(column_numbers))==null)
				{
					leftElements_and_numbers.put(parentdata.get(i).get(column_numbers),1);
				}
				else
					leftElements_and_numbers.put(parentdata.get(i).get(column_numbers),leftElements_and_numbers.get(parentdata.get(i).get(column_numbers))+1);
				
			}
		}//end of for loop
		int total_left=0,total_right=0;
		for(int i=0;i<unique_elements_number;i++){
			if(i<unique_elements_of_decision.size()){
			if(leftElements_and_numbers.get(unique_elements_of_decision.get(i))!=null)total_left+=leftElements_and_numbers.get(unique_elements_of_decision.get(i));
			if(rightElements_and_numbers.get(unique_elements_of_decision.get(i))!=null)total_right+=rightElements_and_numbers.get(unique_elements_of_decision.get(i));	
			}
		}
		
		for(Double key:leftElements_and_numbers.keySet()){
			Double probability=(double)leftElements_and_numbers.get(key)/(double)total_left;
			left_entropy-=probability*(Math.log(probability)/Math.log(2));
		}
		for(Double key:rightElements_and_numbers.keySet()){
			Double probability=(double)rightElements_and_numbers.get(key)/(double)total_right;
			right_entropy-=probability*(Math.log(probability)/Math.log(2));
		}
		
		Double child=((double)total_left/(double)row_numbers)*left_entropy+((double)total_right/(double)row_numbers)*right_entropy;
		return  child;
		
	}
	



	private Double calculateParentgain() {
		// TODO Auto-generated method stub
		row_numbers=parentdata.size();
		column_numbers=parentdata.get(0).size()-1;
		double Entropy=0.0;
		HashMap<Double, Integer> uniques_and_appearance=new HashMap<Double,Integer>();
		for(int i=0;i<row_numbers;i++){
			if(uniques_and_appearance.get(parentdata.get(i).get(column_numbers))==null)uniques_and_appearance.put(parentdata.get(i).get(column_numbers), 1);
			else uniques_and_appearance.put(parentdata.get(i).get(column_numbers),uniques_and_appearance.get(parentdata.get(i).get(column_numbers))+1);
			
		}
		unique_elements_of_decision=new ArrayList<Double>(uniques_and_appearance.keySet());
		unique_elements_number=Math.max(unique_elements_number, unique_elements_of_decision.size());
		for(Double unique: uniques_and_appearance.keySet()){
			Double probablilty=(double)uniques_and_appearance.get(unique)/(double)row_numbers;
			Entropy+=-(Double)probablilty*Math.log10(probablilty)/Math.log10(2);
		}
		
		
		
		
		return Entropy;
	}
	
	
	
	
	
	
	
	
}
