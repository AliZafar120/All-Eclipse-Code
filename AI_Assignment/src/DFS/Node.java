package DFS;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Node {
	
	String name;
	Node parent;
	String discovered;
	int depth;

	ArrayList<Node> adjacentNodes;
	
	public Node(String nodeName) {
		// TODO Auto-generated constructor stub
	name=nodeName;
	parent=null;
	depth=-1;
	discovered="no";
	adjacentNodes= new ArrayList<Node>();
	}

}
