package Test;

import java.util.ArrayList;
import java.util.LinkedList;

import Cases.Case1;
import Cases.Case1.Node;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase1 {

	Case1 mycase= new Case1();
	Case1 basisSet_2= new Case1();
	Case1 basisSet_3= new Case1();
	Case1 basisSet_4= new Case1();
	
	@Test
	public void testSearchGoal() {
	
		//for basis path sets no 1 case
		assertEquals("Reached Goal", mycase.SearchGoal(new Node("A"),new Node("A")));
		
	
		//for basis path sets no 2 case
		assertEquals("Couldn't Reach Goal", mycase.SearchGoal(new Node("A"),new Node("B")));
		
		//for basis path sets no 3 case
		Node root=new Node("A");
		root.adjacentNodes=new ArrayList<Node>(){{add(new Node("B")); add(new Node("D"));}};
		
		assertEquals("Couldn't Reach Goal", mycase.SearchGoal(root,new Node("C")));
			
		
		//for basis path sets no 4 case
	
		 root=new Node("A");
		root.adjacentNodes=new ArrayList<Node>(){{add(new Node("B")); add(new Node("D")); add(new Node("C"));}};
		
		assertEquals("Reached Goal", mycase.SearchGoal(root,new Node("C")));
		
		
	}

}
