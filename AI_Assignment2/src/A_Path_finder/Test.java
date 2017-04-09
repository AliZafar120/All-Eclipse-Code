package A_Path_finder;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Block[][] sf= new Block[2][2];
		sf [1][1] = new Block(3,4);
		sf[0][0]= new Block(1,1);
		sf[1][1].f_value=10;
		sf[0][0].f_value=5;
		
		
		PriorityQueue<Block>open= new PriorityQueue<Block>(4,new BlockComaparator());
	
		ArrayList<Block> tst= new ArrayList<Block>();
		
		//tst.add(sf[1][1]);
		Block b =sf[1][1];
		open.add(b);
		open.add(sf[0][0]);
		if(open.contains(sf[1][1]))System.out.println("Both are equal");
		for(Block a:open){
			System.out.println(a.f_value);
		}
		
	//	if(tst.contains(b))System.out.println("Both are equal");
		

	}

}
