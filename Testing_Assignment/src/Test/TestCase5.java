package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Cases.Case5;

public class TestCase5 {

	Case5 mycase= new Case5();
	
	@Test
	public void testprocessInput() throws NumberFormatException, IOException {
			//for basis path set no 1 case []
		mycase.processInput("");
		assertEquals(0, mycase.rows.size());
		//for basis path set no 2 case []
		mycase.processInput("12.34");
		assertEquals(0, mycase.rows.size());
		//for basis path set no 3 case []
		mycase.processInput(",");
		assertEquals(1, mycase.rows.size());
		assertEquals(0, mycase.rows.get(0).size());//empty row added
		//for basis path set no 4 case []
		mycase.processInput("12.34 , 15.23");
		assertEquals(1, mycase.rows.size());
		assertEquals(2, mycase.rows.get(0).size());//two elements in added row
			
	}

}
