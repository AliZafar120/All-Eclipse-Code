package Test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Cases.Cases10;

public class TestCases10 {

	Cases10 mycase= new Cases10();
	
	@Test
	public void testCalculate_child_entropy() {
		
		//for basis path set no 1 
		int left=0;
		int right=0;
		HashMap<Integer, Integer> left_uniques= new HashMap<Integer, Integer>();
		HashMap<Integer, Integer>right_uniques= new HashMap<Integer, Integer>();
		int totalparentnum=1;
		double parent_gain=0;
		mycase.rootgain=0;
	   	assertEquals(0.0,mycase.calculate_child_entropy(left, right, left_uniques, right_uniques, totalparentnum, parent_gain),.001);
		
	   	//for basis path set 2
	   	left_uniques.put(0, 1);
		left=1;
	   	assertEquals(0.0,mycase.calculate_child_entropy(left, right, left_uniques, right_uniques, totalparentnum, parent_gain),.001);
		//for basis path set 3
	   	left_uniques= new HashMap<Integer, Integer>();
	   	left=0;
	   	right=1;
		right_uniques.put(0, 1);
	   	assertEquals(0.0,mycase.calculate_child_entropy(left, right, left_uniques, right_uniques, totalparentnum, parent_gain),.001);
		   	
	}

}
