package DFS;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Depth_First_Search {
	
	
	Node root;
	Node  goal; //final state
	String dataFilePath;
	HashMap<String, ArrayList<String>> connectedNodeRelation;
	
	
	public Depth_First_Search(String filepath,String root, String goal) {
		dataFilePath=filepath;
		this.root= new Node(root);
		this.goal= new Node(goal);
		connectedNodeRelation= new HashMap<String, ArrayList<String>>();
		
	}
	
	public void BuildGraph() throws IOException {
		getInputFromFile();

		root.depth=0;
	
		Stack<Node> statesStack= new Stack<Node>();
		Node currentState;

		
		statesStack.push(root);

		
		while (statesStack.size()>0) {
			
			currentState=statesStack.pop();
			
			if(currentState.discovered.compareTo("no")==0 && !statesStack.contains(currentState)){
				currentState.discovered="yes";	
				
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
	
	
	public void SearchGoal(){
		Stack<Node>nodeStack= new Stack<Node>();
		nodeStack.push(root);
	
		
		Node currentNode= new Node("");
		Boolean goalFound=false;
		
		while (nodeStack.size()>0) {
		
			currentNode=nodeStack.pop();
			System.out.printf("Currently in "+currentNode.name+" and Depth "+currentNode.depth);
			System.out.println();
			if(currentNode.name.equals(goal.name)){
				goalFound=true;
				break;
			}
			for(int i=0;i<currentNode.adjacentNodes.size();i++){
				nodeStack.push(currentNode.adjacentNodes.get(i));
			}
			
			
		}
		
		if(goalFound){ System.out.println("Reached Goal");
			System.out.printf("Goal Depth %d",currentNode.depth);
		
		}
		else System.out.println("Couldn't Reach Goal");
		
		
	}
	
	
	
	
	
	public void getInputFromFile() throws IOException{
		InputStream fileStream= new FileInputStream(new File(dataFilePath));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		while ((inputLine=buffer.readLine())!=null) {
			String []tokens=inputLine.split(" ");
			if(!connectedNodeRelation.keySet().contains(tokens[0])){
			
				if(!connectedNodeRelation.keySet().contains(tokens[0]))connectedNodeRelation.put(tokens[0], new ArrayList<String>(){{add(tokens[1]);}});
				
			}
			else {
				connectedNodeRelation.get(tokens[0]).add(tokens[1]);			
			}
		}
		
	/*	for(String states :connectedNodeRelation.keySet()){
			System.out.printf("we are currently in" +states+ "\n");
			
				
			
		}*/
		
		
	}
	
	
	


}
