package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Cases.Case6;

public class TestCase6 {

	Case6 mycase = new Case6();
	@Test
	public void testKmpPreProcess() {
	
			//for basis path set no 1
		mycase.KmpPreProcess("", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		//for basis path set no 2
		mycase.KmpPreProcess("aa", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		//for basis path set no 3
		mycase.KmpPreProcess("aaa", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		assertEquals(1, mycase.result.get(2).intValue());
		//for basis path set no 4
		mycase.KmpPreProcess(",,a", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		assertEquals(1, mycase.result.get(2).intValue());
		//for basis path set no 5
		mycase.KmpPreProcess("  a", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		assertEquals(1, mycase.result.get(2).intValue());
		//for basis path set no 6
		mycase.KmpPreProcess("..a", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		assertEquals(1, mycase.result.get(2).intValue());
		
		//for basis path set no 7
		mycase.KmpPreProcess("aab", new ArrayList<Integer>());
		assertEquals(-1, mycase.result.get(0).intValue());
		assertEquals(0, mycase.result.get(1).intValue());
		assertEquals(1, mycase.result.get(2).intValue());
		
	}

}
