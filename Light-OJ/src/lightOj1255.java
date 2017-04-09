import java.util.ArrayList;
import java.util.Scanner;


public class lightOj1255 {

	public static void KmpPreProcess(String pattern,ArrayList<Integer> ffuntion) {
		
		int i=0,j=-1,m=pattern.length();
		ffuntion.add(-1);
		while (i<m) {
			while (j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j=ffuntion.get(j);
			}
			i++;
			j++;
			ffuntion.add(j);	
		}
		
		
	}
	
	
	public static int kmp(String str,String sstr,ArrayList<Integer> ffuntion) {
		
		int i=0,j=0,count=0;
		int n=str.length(),m=sstr.length();
		
		while(i<n)
		{
			while (j>=0  && str.charAt(i)!=sstr.charAt(j)) {
				j=ffuntion.get(j);
			}
			i++;
			j++;
			if(j==m)
			{
				count++;
				j=ffuntion.get(j);
			}
			
		}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int cases,i;
		String str,sstr;
		ArrayList<Integer>ffuntion= new ArrayList<Integer>();
		
		cases=scanner.nextInt();
		for(i=1;i<=cases;i++)
		{
			str=scanner.next();
			sstr= scanner.next();
			KmpPreProcess(sstr, ffuntion);
			System.out.printf("Case %d: %d\n",i,kmp(str, sstr, ffuntion));
			
		}
		
		
		
		
		
	}

}
