

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
	
	ArrayList<Data> data = new ArrayList<>();
	int threshold;
	double nodeEntropy;
	int dataSize;
	int dataOpt;
	int numberOfClass;
	Node Child[] = new Node[6];
	boolean thresoldOpt[] = new boolean[6];
	boolean nonLeaf;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	void addData(Data dat){
		data.add(dat);
	}
	
	String query(int a[]){
		if(!nonLeaf) return data.get(0).className;
		else return Child[a[threshold]].query(a);
	}
	
	void resolve(){
		dataSize = data.size();
		numberOfClass = totalClasses(data);
		if(numberOfClass < 2) return;
		nonLeaf = true;
		nodeEntropy = calcNodeEntropy(data);
		double maxGainValue = -5456456.0;
		dataOpt = data.get(0).size;
		
		for(int i = 1; i < dataOpt; i++){
			if(thresoldOpt[i]) continue;
			double val = calcGainValue(i);
			if(val > maxGainValue){
				maxGainValue = val;
				threshold = i;
			}
		}
		divideInSets();
	}
	
	void divideInSets(){
		for(int i=1; i < 6; i++){
			Child[i] = new Node();
		}
		for(Data d: data){
			int setNumber = d.data[threshold];
			Child[setNumber].addData(d);
		}
		for(int i=1; i<6; i++){
			Child[i].resolve();
			for(int j = 1; j < 6; j++) Child[i].thresoldOpt[j] = thresoldOpt[j];
			Child[i].thresoldOpt[threshold] = true;
		}
	}
	
	
	double calcGainValue(int dataIndex){
		double res = 0;
		for(int i = 1; i<= 5; i++){
			double toAdd = specificEntropy(dataIndex, i);
			res += toAdd;
		}
		return nodeEntropy - res;
	}
	
	
	double specificEntropy(int dataIndex, int value){
		ArrayList<Data> dat = getSublist(dataIndex, value);
		int freq = dat.size();
		double P = (double) freq /(double) dataSize;
		double entropy = calcNodeEntropy(dat);
		double res = P * entropy;
		return res;
	}
	
	ArrayList<Data> getSublist(int  dataIndex, int value){
		ArrayList<Data> dat = new ArrayList<>();
		for(Data d: data){
			if(d.data[dataIndex] == value){
				dat.add(d);
			}
		}
		return dat;
	}
	
	
	double calcNodeEntropy(ArrayList<Data> dat){
		
		Map<String, Integer> Frequency = calcFrequency(dat);
		double entropy = 0;
		int sz = dat.size();
		
		for (Map.Entry<String, Integer> entry : Frequency.entrySet()){
			double P = (double) entry.getValue() / (double) sz;
			double toadd = - P * ( Math.log10(P) / Math.log10(2));
			entropy += toadd;
		}
		
		return entropy;
		
	}
	
	Map<String, Integer> calcFrequency(ArrayList<Data> dat){
		Map<String, Integer> Frequency = new HashMap<>();
		for(Data d: dat){
			String className = d.className;
			if(Frequency.containsKey(className)){
				int f = Frequency.get(className);
				Frequency.remove(className);
				Frequency.put(className, f + 1);
			}
			else{
				Frequency.put(className, 1);
			}
		}
		return Frequency;
	}
	
	int totalClasses(ArrayList<Data> dat){
		Set <String> st = new HashSet<>();
		for(Data d: dat){
			st.add(d.className);
		}
		return st.size();
	}
}
