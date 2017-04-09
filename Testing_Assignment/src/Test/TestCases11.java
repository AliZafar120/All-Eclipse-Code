package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Cases.Cases11;

public class TestCases11 {

	Cases11 mycase= new Cases11();
	@Test
	public void testMin() {
		//for basis path set no 1
		mycase.min("0 0");
		assertEquals(0, mycase.result);
		//for basis path set no 2
		mycase.min("1 0");
		assertEquals(2147483647, mycase.result);
		//for basis path set no 3 
		mycase.min("1 1 0");
		assertEquals(0, mycase.result);
		//for basis path set no 4
		mycase.min("1 1 2147483647");
		assertEquals(2147483647, mycase.result);
		
	}

}
