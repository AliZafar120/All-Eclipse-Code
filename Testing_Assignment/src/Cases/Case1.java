package Cases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Case1 {
	

	public String SearchGoal(Node root, Node goal){
		Queue<Node>nodeQueue= new LinkedList<Node>();
		nodeQueue.add(root);
	
		
		Node currentNode= new Node("");
		Boolean goalFound=false;
		
		while (nodeQueue.size()>0) {
		
			currentNode=nodeQueue.poll();
			System.out.printf("Currently in "+currentNode.name+" and Depth "+currentNode.depth);
			System.out.println();
			if(currentNode.name.equals(goal.name)){
				goalFound=true;
				break;
			}
			for(int i=0;i<currentNode.adjacentNodes.size();i++){
				nodeQueue.add(currentNode.adjacentNodes.get(i));
			}
			
			
		}
		
		if(goalFound){ 
			return "Reached Goal";
		
		}
		else return "Couldn't Reach Goal";
		
		
	}
	
	
	
	
	
	
	
	public static class Node {
		
		public String name;
		public Node parent;

		public int depth;
		public int distance;
		public ArrayList<Node> adjacentNodes;
		
		public Node(String nodeName) {
			// TODO Auto-generated constructor stub
		name=nodeName;
		parent=null;
		distance=-1;
		depth=-1;
		adjacentNodes= new ArrayList<Node>();
		}

	}

	

}
