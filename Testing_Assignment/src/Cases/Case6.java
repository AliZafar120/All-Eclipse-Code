package Cases;

import java.util.ArrayList;

public class Case6 {

	public static ArrayList<Integer> result;
	public static void KmpPreProcess(String pattern,ArrayList<Integer> ffuntion) {
		
		int i=1,j=-1,m=pattern.length();
		ffuntion.add(-1);
		 
		result=new ArrayList<Integer>();
		result.add(-1);
		while (i<m) {
			while (j>0
					&& 
				pattern.charAt(i)!=pattern.charAt(j)) {
				if(pattern.charAt(j)==',' ||
				   pattern.charAt(j)==' ' ||
				   pattern.charAt(j)=='.' ) break;
				j=ffuntion.get(j);
			}
			i++;
			j++;
			ffuntion.add(j);
			result.add(j);
		}
		
	
	}
	
}
