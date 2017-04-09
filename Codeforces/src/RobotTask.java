import java.util.ArrayList;
import java.util.Scanner;


public class RobotTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double startTime = System.currentTimeMillis();
		
		int totalnums,dirchange,countInfo,k;
		Scanner inp = new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		while (inp.hasNext()) {
			countInfo=0;
			dirchange=0;
			totalnums= inp.nextInt();
			for(int i=0;i<totalnums;i++)
			{
				list.add(inp.nextInt());
			}
			k=0;
			while(list.size()!=countInfo)
			{
				if(k>=list.size() && k!=0) {dirchange++;k=0;}
				if(list.get(k)==0){countInfo++;list.remove(k);list.add(k,-1);}
				else if(list.get(k)>=countInfo && list.get(k)>0){countInfo++;list.remove(k);list.add(k,-1);}
			    k++;
				
				
			}
			System.out.println(dirchange);
			
			
		}
		
		
		
		
		
		
		System.out.println(startTime-System.currentTimeMillis());

	}

}
