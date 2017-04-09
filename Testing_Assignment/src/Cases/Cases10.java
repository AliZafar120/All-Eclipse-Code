package Cases;

import java.util.HashMap;

public class Cases10 {
	public double rootgain;
	public double calculate_child_entropy(int left,int right,HashMap<Integer, Integer> left_uniques,HashMap<Integer, Integer>right_uniques,int totalparentnum,double parent_gain){
		
		
		Double child_entropy=0.0,child_left_entropy=0.0,child_right_entropy=0.0;
		for(int i=0;i<left_uniques.size() || i<right_uniques.size();i++){
			if(i<left_uniques.size())child_left_entropy+=calculate_entropy(((double)(left_uniques.get(i)))/left);
			if(i<right_uniques.size())child_right_entropy+=calculate_entropy(((double)(right_uniques.get(i)))/right);
			
		}
		
		
		child_entropy=rootgain-(left/totalparentnum)*child_left_entropy+(right/totalparentnum)*child_right_entropy;
		
	System.out.println(child_entropy);
		return child_entropy;
	}

	private Double calculate_entropy(double d) {
		// TODO Auto-generated method stub
		return 0.0;
	}
	
}
