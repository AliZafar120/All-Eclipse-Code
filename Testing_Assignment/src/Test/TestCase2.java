package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Cases.Case2;
import Cases.Case2.Node;

public class TestCase2 {

	
	Case2 mycase= new Case2();
	@Test
	public void testBuildGraph()  {
		
		//for basis path set 1
		HashMap<String, ArrayList<String>> connectedNodeRelation= new HashMap<String, ArrayList<String>>();
		connectedNodeRelation.put("C",new ArrayList<String>(){{add("A");add("F");}});
		 mycase.BuildGraph(new Node("A"), connectedNodeRelation);
		assertEquals(0, mycase.getroot.adjacentNodes.size());
		
		 //for basis path set 2
		 connectedNodeRelation.put("A",new ArrayList<String>(){{add("B");add("E");}});
		 mycase.BuildGraph(new Node("A"), connectedNodeRelation);
		 assertEquals(2, mycase.getroot.adjacentNodes.size());
				 
		 
	}

}
