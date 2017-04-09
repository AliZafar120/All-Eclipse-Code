package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Cases.Case7;

public class TestCase7 {

	Case7 mycase= new Case7();
	@Test
	public void testmagicNumber() {
		//for basis path set no 1
		mycase.magicNumber("0");
		assertEquals("", mycase.final_string);
		//for basis path set no 2
		mycase.magicNumber("1 2");
		assertEquals("9", mycase.final_string);
		//for basis path set no 3
		mycase.magicNumber("1 3");
		assertEquals("4", mycase.final_string);
		//for basis path set no 4
		mycase.magicNumber("1 5");
		assertEquals("11", mycase.final_string);
	}

}
