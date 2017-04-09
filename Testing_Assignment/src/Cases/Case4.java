package Cases;

import java.util.Scanner;

public class Case4 {
	
	public String final_string;

	public void solve(String givenInput){
		Scanner input= new Scanner(givenInput);
		final_string="";
		String str;
		int base=1000004933,mod=1000001857;
		int hash,i,length,min,revhash,revbase;
		
		while (input.hasNext()) {
			str=input.next();
			length=str.length()-1;
			hash=0;
			revbase=1;
			revhash=0;
			min=0;
			
			for(i=length;i>=0;i--)
			{
				hash=((hash*base)+(int)str.charAt(i))%mod;
				revhash=(((int)str.charAt(i)*revbase)+revhash)%mod;
				if(hash==revhash)min=length-i;
				revbase=(base*revbase)%mod;
			}
			System.out.printf(str);
			final_string+=str;
			for(i=length-min-1;i>=0;i--)
				{System.out.printf("%c",str.charAt(i));final_string+=str.charAt(i);}
			System.out.println();
			final_string+=" new_line ";
			
	}
	
}
}
