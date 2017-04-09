import java.util.ArrayList;

public class Tree {

	private Node root;
	private EntropyCalculation entropy= new EntropyCalculation();
	
	public Tree(ArrayList<ArrayList<Double>> allInputs) {
		// TODO Auto-generated constructor stub
	
	root=Tree_Build(root,allInputs);
	}
	

	private Node Tree_Build(Node current, ArrayList<ArrayList<Double>> inputs) {
		// TODO Auto-generated method stub
		
		entropy.maxGainCalculation(inputs);
		if(entropy.reached_maxgain){
			current= new Node(entropy.decision);
			return current;
		}
		
		current= new Node(entropy.maxgain_colnum,inputs.get(entropy.maxgain_rownum).get(entropy.maxgain_colnum));
		ArrayList<ArrayList<Double>> leftInputs= new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> rightInputs= new ArrayList<ArrayList<Double>>();
		for(ArrayList<Double> a: inputs){
			if(current.value>=a.get(current.data_column))leftInputs.add(a);
			else rightInputs.add(a);
			
		}
		current.left=Tree_Build(current.left, leftInputs);
		current.Right=Tree_Build(current.Right, rightInputs);
		return current;
	}
	
	public void Traverse_Tree(ArrayList<Double> enquiry){
		traverse(root,enquiry);
	}

	private void traverse(Node current, ArrayList<Double> enquiry) {
		// TODO Auto-generated method stub
		if(current.left==null &&  current.Right==null){
			System.out.println(current.value);
			return;
		}
		if(current.value>=enquiry.get(current.data_column))traverse(current.left, enquiry);
		else traverse(current.Right, enquiry);
	}	
}
