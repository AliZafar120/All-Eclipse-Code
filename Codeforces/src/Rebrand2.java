import java.util.Iterator;
import java.util.Scanner;


public class Rebrand2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
	    long cases,len;
	    char a,b;
		StringBuilder str;
		
		len=inp.nextLong();
		cases=inp.nextLong();
		str=new StringBuilder(inp.next());
		while (cases-->0) {
			a=inp.next().charAt(0);
			b=inp.next().charAt(0);
			for (int i = 0; i < len; i++) {
				if(str.charAt(i)==a)str.setCharAt(i, b);
				else if(str.charAt(i)==b)str.setCharAt(i, a);
			}
			
		}
		inp.close();
		System.out.println(str);

	}

}
