package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Cases.Case4;

public class TestCase4 {

	Case4 mycase= new Case4();
	
	@Test
	public void testsolve() {
		//for basis path set no 1 path [1-2-Exit]

		mycase.solve("");
		assertEquals("", mycase.final_string);
		//for basis path set no 2 path [1-2-3-4-(5-7-8-9-10-6)-11-12-13-16-2-Exit]
		mycase.solve("a");
		assertEquals("a new_line ", mycase.final_string);
		//for basis path set no 3 path [1-2-3-4-(5-(7-8-9-10-6)-5-(7-8-10-6))-5-11-12-(13-15-14)-13-16-2-Exit]
		mycase.solve("aa");
		assertEquals("aaa new_line ", mycase.final_string);
		
	}

}
