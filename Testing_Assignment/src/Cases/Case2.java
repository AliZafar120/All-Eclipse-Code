package Cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class Case2 {
	
	public static class Node {
		
		public String name;
		public Node parent;
		public String discovered;
		public int depth;

		public ArrayList<Node> adjacentNodes;
		
		public Node(String nodeName) {
			// TODO Auto-generated constructor stub
		name=nodeName;
		parent=null;
		depth=-1;
		discovered="no";
		adjacentNodes= new ArrayList<Node>();
		}


		}
	
	public Node getroot;

	public void BuildGraph(Node root,HashMap<String, ArrayList<String>> connectedNodeRelation)  {


		root.depth=0;
		getroot=root;
	
		Stack<Node> statesStack= new Stack<Node>();
		Node currentState;

		
		statesStack.push(root);

		
		while (statesStack.size()>0) {
			
			currentState=statesStack.pop();
			
			
				
				if(connectedNodeRelation.get(currentState.name)!=null){
						for(int i=0; i<connectedNodeRelation.get(currentState.name).size();i++){
							Node childNode= new Node(connectedNodeRelation.get(currentState.name).get(i));
							childNode.parent=currentState;
							childNode.depth=currentState.depth+1;
							currentState.adjacentNodes.add(childNode);
							statesStack.push(childNode);
							
							
						}
				}
								
			}
			
		}

	}



	


