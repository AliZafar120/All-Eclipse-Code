import java.util.ArrayList;
public class Tree {
	
	private Node root;
	private Entropy entropy=new Entropy();
	
	public Tree(ArrayList<ArrayList<Double>> data){
		root=build_tree(root,data);
	}
	public Node build_tree(Node current,ArrayList<ArrayList<Double>> data){
		
		entropy.determineMaxGain(data);
		if(entropy.isGainZero){
			current=new Node(entropy.decision);
			return current;
		}
		current=new Node(entropy.maxj, data.get(entropy.maxi).get(entropy.maxj));
		ArrayList<ArrayList<Double>> leftData=new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> rightData=new ArrayList<ArrayList<Double>>();
		for(ArrayList<Double> r:data){
			if(current.value>=r.get(current.type))leftData.add(r);
			else rightData.add(r);
		}
		current.left=build_tree(current.left,leftData);
		current.right= build_tree(current.right,rightData);
		return current;
	}
	public void traverse_tree(ArrayList<Double> testData){
		traverse(root, testData);
	}
	public void traverse(Node current,ArrayList<Double> testData){
		if(current.left==null&&current.right==null){
			System.out.println(current.value);
			return;
		}
		if(current.value>=testData.get(current.type))traverse(current.left, testData);
		else traverse(current.right, testData);
	}
}
