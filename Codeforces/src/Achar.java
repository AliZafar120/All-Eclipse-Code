import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Achar {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Scanner inp = new Scanner(new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"));
		Scanner inp = new Scanner(System.in);
		int words,len,max,singmax;
		HashMap<String ,Integer> maps= new HashMap<String, Integer>();
		String []list;
		String sing = null;
		words=inp.nextInt();
		list = new String[words];
		
		for(int i=0;i<words;i++)
		{
			list[i]=inp.next();
			len=list[i].length();
			char a='.',b='.',c;
			boolean exception=false;
			for(int j=0;j<len;j++)
			{
				if(a=='.'){a=list[i].charAt(j);}
				else if(b=='.' && a!='.' && list[i].charAt(j)!=a){b=list[i].charAt(j);}
				else if(a!='.' && list[i].charAt(j)!=a && b!='.' && list[i].charAt(j)!=b)
				exception=true;
		
			}
			if(!exception)
			{
				if(b=='.')
				{
					if(maps.containsKey(""+a))maps.put(""+a, maps.get(""+a)+len);
					else maps.put(""+a, len);
				}
				else
				{
				//if(!maps.containsKey(""+b+a) || !maps.containsKey(""+a+b)){maps.put(""+a+b, len);
					if(maps.containsKey(""+b+a)){c=a;a=b;b=c;}
					if(!maps.containsKey(""+b+a) && !maps.containsKey(""+a+b)) maps.put(""+a+b, len);
					else maps.put(""+a+b, len+maps.get(""+a+b));
				}
			}
			
		}
		
	

		
		max=0;
		singmax=0;
		for (String ky : maps.keySet()) {
			int total=0,res=0;
			for (int j = 0; j < ky.length(); j++) {
				if(maps.containsKey(""+ky.charAt(j)))total+=maps.get(""+ky.charAt(j));
			}
			if(ky.length()>1)res=total+maps.get(ky);
			else {res=maps.get(ky);if(res>singmax){singmax=res;sing=ky;}}
			if(res>max) max=res;
		}
		
		for(String ky : maps.keySet())
		{
			if(ky.length()>1 || ky.compareTo(sing)==0)continue;
			else if(ky.length()+singmax>max) max=singmax+maps.get(ky);
		}
		
		System.out.println(max);

}
}