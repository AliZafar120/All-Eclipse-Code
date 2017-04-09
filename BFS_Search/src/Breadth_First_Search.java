import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Breadth_First_Search {

	String initialState;//beginning state
	String  goalState; //final state
	String dataFilePath;
	
	int currentDepth;//depth of current state
	HashMap<String, Node> connectedNodeRelation;
	
	public Breadth_First_Search(String filepath,String start, String goal) {
		dataFilePath=filepath;
		initialState=start;
		goalState=goal;
		connectedNodeRelation= new HashMap<String, Node>();
		
	}
	
	public void TraverseGraph() throws IOException {
		getInputFromFile();
	
		Queue<String> stateQueue= new LinkedList<String>();
		stateQueue.add(initialState);
		long forDepthCount=0;
		currentDepth=0;
		
		
		
		
		
		
		
		
			
		
	}
	
	public void getInputFromFile() throws IOException{
		InputStream fileStream= new FileInputStream(new File(dataFilePath));
		BufferedReader buffer= new BufferedReader(new InputStreamReader(fileStream));
		String inputLine;
		while ((inputLine=buffer.readLine())!=null) {
			String []tokens=inputLine.split(" ");
			if(!connectedNodeRelation.keySet().contains(tokens[0])){
				Node newNode= new Node(tokens[0]);
				newNode.connectedStates.add(tokens[1]);
				connectedNodeRelation.put(tokens[0], newNode);
			}
			else {
				connectedNodeRelation.get(tokens[0]).connectedStates.add(tokens[1]);			
			}
		}
		
/*		for(String states :connectedNodeRelation.keySet()){
			System.out.printf("we are currently in" +states+ "\n");
			
				
			
		}*/
		
		
	}
	
	
	

	
	
	
}
