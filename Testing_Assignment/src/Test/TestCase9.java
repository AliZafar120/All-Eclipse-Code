package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Cases.Case9;
import Cases.Case9.Data;

public class TestCase9 {

	
	
	Case9 mycase= new Case9();
	
	@Test
	public void testResolve() {
		
		// for basis path set 1
	mycase.resolve(new ArrayList<Data>(), 1, null,0);
	assertEquals(-5456456.0, mycase.maxgainValue,.001);
		
	//for basis path set 2
	mycase.resolve(new ArrayList<Data>(){{add(new Data(""));}}, 3, null,0);
	assertEquals(-5456456.0, mycase.maxgainValue,.001);
	
	//for basis path set 3
	boolean thresoldOpt[]= new boolean[2];
	thresoldOpt[1]=true;
	mycase.resolve(new ArrayList<Data>(){{add(new Data("1,2"));}}, 3,thresoldOpt,0);
	assertEquals(-5456456.0, mycase.maxgainValue,.001);
	
	//for basis path set 4

	thresoldOpt[1]=false;
	mycase.resolve(new ArrayList<Data>(){{add(new Data("1,2"));}}, 3,thresoldOpt,-5456456.0);
	assertEquals(-5456456.0, mycase.maxgainValue,.001);
	
	//for basis path set 5
	mycase.resolve(new ArrayList<Data>(){{add(new Data("1,2"));}}, 3,thresoldOpt,0.0);
	assertEquals(0.0, mycase.maxgainValue,.001);
	
	}

}
