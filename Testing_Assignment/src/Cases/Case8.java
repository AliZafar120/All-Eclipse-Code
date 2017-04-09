package Cases;



import java.util.ArrayList;



public class Case8 {
	public Node root;
	public double final_value;
	
	public void traverse(Node current, ArrayList<Double> enquiry) {
		// TODO Auto-generated method stub
		if(current==null)
			current=root;
		
		if(current.left==null &&  current.Right==null){
			System.out.println(current.value);
			final_value=current.value;
			return;
		}
		if(current.value>=enquiry.get(current.data_column))traverse(current.left, enquiry);
		else traverse(current.Right, enquiry);
	}	
	
	
	public static class Node {
		public int data_column;
		public double value;
		public Node left,Right;

		public Node(int col,Double val) {
			// TODO Auto-generated constructor stub
		data_column=col;
		value=val;
		this.left=this.Right=null;
		
		}
		
		public Node(Double  val) {
			// TODO Auto-generated constructor stub
			value=val;
		}
		public Node(){
			this.left=this.Right=null;
		}
		
	}

}
