package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Cases.Case8;
import Cases.Case8.Node;

public class TestCase8 {

	Case8 mycase= new Case8();
	@Test
	public void testtraverse() {
		
		//for basis path set no 1
		Node current=new Node(1,20.0);
		mycase.traverse(current, new ArrayList<Double>());
		assertEquals(20.0, mycase.final_value,.001);
		//for basis path set  no 2
	    
	    mycase.root=new Node(1,20.0);
		mycase.traverse(null, new ArrayList<Double>());
		assertEquals(20.0, mycase.final_value,.001);
		//for basis path set  no 3
		 mycase.root=new Node(0,20.0);
		 mycase.root.left=new Node(1,21.0);
		 ArrayList<Double> enquiry= new ArrayList<Double>(){{add(16.0);}};
		 mycase.traverse(null, enquiry);
		 assertEquals(21.0, mycase.final_value,.001);
		 //for basis path set no 4
		 
		 mycase.root=new Node(0,20.0);
		 mycase.root.Right=new Node(1,21.0);
		 enquiry= new ArrayList<Double>(){{add(22.0);}};
		 mycase.traverse(null, enquiry); 
		 assertEquals(21.0, mycase.final_value,.001);
	}

}
