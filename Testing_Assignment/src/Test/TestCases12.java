package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Cases.Cases12;

public class TestCases12 {

	Cases12 mycase= new Cases12();
	
	@Test
	public void testchangename() {
		//for basis path set no 1
	mycase.changename("3 0 abc");
	assertEquals("abc", mycase.final_string);
	//for basis path set no 2
	mycase.changename("0 1 abc cd ef");
	assertEquals("abc", mycase.final_string);
	//for basis path set no 3
	mycase.changename("1 1 abc ad ef");
	assertEquals("ebc", mycase.final_string);
	//for basis path set no 4
	mycase.changename("1 1 abc ed af");
	assertEquals("ebc", mycase.final_string);
	//for basis path set no 5
	mycase.changename("2 1 abc ed sf");
	assertEquals("abc", mycase.final_string);

	
	}

}
