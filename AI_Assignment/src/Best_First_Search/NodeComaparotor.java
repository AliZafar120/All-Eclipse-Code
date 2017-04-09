package Best_First_Search;

import java.util.Comparator;

public class NodeComaparotor implements Comparator<Node>{

	@Override
	public int compare(Node node1, Node node2) {
		// TODO Auto-generated method stub
		if(node1.distance>node2.distance)return 1;
		if(node1.distance<node2.distance)return -1;
		
		return 0;
	}

}
