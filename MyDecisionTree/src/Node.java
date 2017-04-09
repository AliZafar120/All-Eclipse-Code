
public class Node {
	public int data_column;
	public double value;
	Node left,Right;

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
