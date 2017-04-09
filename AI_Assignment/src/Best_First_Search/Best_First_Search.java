package Best_First_Search;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Best_First_Search {

	Node root;
	Node  goal; //final state
	String dataFilePath;
	String weightFilePath;
	HashMap<String, ArrayList<String>> connectedNodeRelation;
	HashMap<String,Integer> nodeWeights;
	Stack<Node> pathPrinter= new Stack<>();
	
	
	public Best_First_Search(String initial,String end,String dFilePath,String wFilePath) {
		// TODO Auto-generated constructor stub
		root=new Node(initial);
		goal=new Node(end);
		
		dataFilePath=dFilePath;
		weightFilePath=wFilePath;
		nodeWeights= new HashMap<String, Integer>();
		connectedNodeRelation= new HashMap<String, ArrayList<String>>();
	
	}
	
	public void get_goal(){
		
	PriorityQueue<Node> priorityQueue= new PriorityQueue<>(nodeWeights.size(), new NodeComaparotor());
	priorityQueue.add(root);
	
	Node current= root;
	
	
	boolean reach_goal=false;
	
	Node MinNode=new Node("");
	MinNode.distance= current.distance;
	
/*	while(!reach_goal){*/
	
		while (!priorityQueue.isEmpty() && !reach_goal) {
			current=priorityQueue.poll();
			if(current.name.equals(goal.name))reach_goal=true;
			
			
			if(!reach_goal)for(int i=0;i<current.adjacentNodes.size();i++){
				priorityQueue.add(current.adjacentNodes.get(i));
			}
			pathPrinter.add(current);
		}
		
	/*}*/
	
		while(!pathPrinter.isEmpty()){
			System.out.println(pathPrinter.pop().name);
		}
	
		
		
	}
	
	public void BuildGraph() throws IOException {
		getInputFromFile();

		root.distance=nodeWeights.get(root.name);
	
		Stack<Node> statesStack= new Stack<Node>();
		Node currentState;

		
		statesStack.push(root);

		
		while (statesStack.size()>0) {
			
			currentState=statesStack.pop();

				if(connectedNodeRelation.get(currentState.name)!=null){
						for(int i=0; i<connectedNodeRelation.get(currentState.name).size();i++){
							Node childNode= new Node(connectedNodeRelation.get(currentState.name).get(i));
							childNode.parent=currentState;
							childNode.distance=nodeWeights.get(connectedNodeRelation.get(currentState.name).get(i));
							currentState.adjacentNodes.add(childNode);
							statesStack.push(childNode);
							
							
						}
				}
								
			
			
		}
	
	}
	
	
	
	public void getInputFromFile() throws IOException{
		
		InputStream fileStream= new FileInputStream(new File(weightFilePath));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		
		while ((inputLine=buffer.readLine())!=null) {
			String []tokens=inputLine.split(" ");
			nodeWeights.put(tokens[0], Integer.parseInt(tokens[1]));
		}
		
		
		
		
		
	//reading connections 	
	 fileStream= new FileInputStream(new File(dataFilePath));
	 buffer= new BufferedReader(new InputStreamReader(fileStream));
		
		while ((inputLine=buffer.readLine())!=null) {
			String []tokens=inputLine.split(" ");
			if(!connectedNodeRelation.keySet().contains(tokens[0])){
			
				if(!connectedNodeRelation.keySet().contains(tokens[0]))connectedNodeRelation.put(tokens[0], new ArrayList<String>(){{add(tokens[1]);}});
				
			}
			else {
				connectedNodeRelation.get(tokens[0]).add(tokens[1]);			
			}
		}
		
		
	}
}
