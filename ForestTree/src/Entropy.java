import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Entropy {

	private ArrayList<ArrayList<Double>> data;
	private ArrayList<Double> class_set;
	private int size1,size2,size3=0;
	public boolean isGainZero;
	public int maxi,maxj;
	public double decision;
	
	public void determineMaxGain(ArrayList<ArrayList<Double>> data){
		this.data=data;
		isGainZero=false;
		double parent_entropy=calculate_par_entropy();
		//System.out.println(size3);
		if(parent_entropy==0){
			isGainZero=true;
			decision=data.get(0).get(size2);
			return;
		}
		double maxen=0.0;
		for(int i=0;i<size2;i++){
			Map<Double, Integer> isDuplicate=new HashMap<Double, Integer>();
			for(int j=0;j<size1;j++){
				if(isDuplicate.containsKey(data.get(j).get(i)))continue;
				else isDuplicate.put(data.get(j).get(i), 1);
				double avg_entropy=calculate_child_entropy(i, data.get(j).get(i));
				if(maxen<(parent_entropy-avg_entropy)){
					maxen=(parent_entropy-avg_entropy);
					this.maxi=j;this.maxj=i;
				}
			}
		}
	}
	public double calculate_par_entropy(){
		double entropy=0.0;
		Map<Double,Integer> mp=new HashMap<Double,Integer>();
		size1=data.size();size2=data.get(0).size()-1;	
		for(int i=0;i<size1;i++){
			//System.out.println(data.get(i).get(size2));
			int cnt=(mp.get(data.get(i).get(size2))==null)?0:mp.get(data.get(i).get(size2));
			mp.put(data.get(i).get(size2), cnt+1);
		}
		class_set=new ArrayList<Double>(mp.keySet());
		size3=Math.max(size3,class_set.size());
		for (Double key: mp.keySet()) {
			double probability = (double)mp.get(key)/(double)size1;
			entropy+=-probability*(Math.log(probability)/Math.log(2));
		}
		return entropy;
	}
	public double calculate_child_entropy(int index,double value){
		double left_entropy=0.0,right_entropy=0.0;
		double n=0.0;
		double[] left=new double[size3];
		double[] right=new double[size3];
		for(int i=0;i<size3;i++){
			left[i]=0.0;
			right[i]=0.0;
		}
		for(int i=0;i<size1;i++){
			double c=data.get(i).get(size2);
			if(data.get(i).get(index)<=value)left[(int)c]=left[(int)c]+1;
			else{
				n++;
				right[(int)c]=right[(int)c]+1;
			}
		}
		double m=size1-n;
		for(double i:left){
			double probability=(double)i/(double)m;
			if(probability>0){
				left_entropy+=(-1*probability*(Math.log(probability)/Math.log(2)));
			}
		}
		for(double i:right){
			double probability=(double)i/(double)n;
			if(probability>0)right_entropy+=-probability*(Math.log(probability)/Math.log(2));
		}
		double ret=(m/size1)*left_entropy+(n/size1)*right_entropy;
		return ret;
	}
}
