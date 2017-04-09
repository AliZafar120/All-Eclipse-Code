 package A_Path_finder;

import java.util.Comparator;

public class BlockComaparator implements Comparator<Block>{

	@Override
	public int compare(Block block1, Block block2) {
		// TODO Auto-generated method stub
		if(block1.f_value>block2.f_value)return 1;
		else if(block1.f_value<block2.f_value)return -1;
		return 0;
	}

}
