import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Node {
	
	String name;
	Node parent;

	int depth;
	int distance;
	ArrayList<Node> adjacentNodes;
	
	public Node(String nodeName) {
		// TODO Auto-generated constructor stub
	name=nodeName;
	parent=null;
	distance=-1;
	depth=-1;
	adjacentNodes= new ArrayList<Node>();
	}

}
