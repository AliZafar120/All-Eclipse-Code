package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Cases.Case3;
import Cases.Case3.Block;;

public class TestCase3 {

	
	Case3 mycase= new Case3();
	@Test
	public void testSolvedMazePrint() {

		Block start;
		Block end;
		int totalcolumns;
		int totalrows;
		Block board_Blocks[][];
		
		
		//for basis path set 1 [1-(2-3)-2-4-5]
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=0;
		totalrows=0;
		board_Blocks= new Block[1][1];
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("", mycase.final_result);
		//for basis path set 2 [1-(2-3)-2-4-(5-7-8-19-6)-5-Exit]

		totalrows=1;
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		System.out.println(mycase.final_result);
		assertEquals(" new_line ", mycase.final_result);
		
		//for basis path set 3 [1-(2-3)-2-4-5-7-(8-10-11-9)-8-19-6-5-Exit]
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=1;
		totalrows=1;
		board_Blocks= new Block[2][2];
		board_Blocks[1][1]=start;
		
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("- new_line ", mycase.final_result);
		
		//for basis path set 4 [1-(2-3)-2-4-(5-7-(8-10-12-13-9)-8-19-6)-5-Exit]
		
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=1;
		totalrows=1;
		board_Blocks= new Block[2][2];
		Block obstacleblock= new Block(0,1);
		obstacleblock.is_obstacle=true;
		board_Blocks[1][1]=obstacleblock;
		
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("# new_line ", mycase.final_result);
		//for basis path set 5 [1-(2-3)-2-4-(5-7-(8-10-12-14-15-9)-8-19-6)-5-Exit]
		
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=1;
		totalrows=1;
		board_Blocks= new Block[2][2];
		Block startblock= new Block(0,1);
		startblock.is_start=true;
		board_Blocks[1][1]=startblock;
		
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("S new_line ", mycase.final_result);
		// for basis path set 6
		
		
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=1;
		totalrows=1;
		board_Blocks= new Block[2][2];
		Block endblock= new Block(0,1);
		endblock.is_goal=true;
		board_Blocks[1][1]=endblock;
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("G new_line ", mycase.final_result);
		//for basis path set 7 [1-(2-3)-2-4-(5-7-(8-10-12-14-16-18-9)-8-19-6)-5-Exit]
		
		start= new Block(0,0);
		end=new Block(1,1);
		end.parent=start;
		totalcolumns=1;
		totalrows=1;
		board_Blocks= new Block[2][2];
		board_Blocks[1][1]=new Block(2,3);
		
		mycase.SolvedMazePrint(start, end, totalrows, totalcolumns, board_Blocks);
		assertEquals("* new_line ", mycase.final_result);
	}

}
