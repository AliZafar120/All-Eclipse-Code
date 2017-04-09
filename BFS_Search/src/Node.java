import java.util.HashSet;
import java.util.Set;


public class Node {
	
	String name;
	String visitState;
	String depth;
	Set<String> connectedStates;
	
	public Node(String nodeName) {
		// TODO Auto-generated constructor stub
	name=nodeName;
	visitState="NotVisited";
	connectedStates= new HashSet<String>();
	}

}
