import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;




public class Vanya_and_Food_Processor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n,h,k,fill,adp,res=0,next=0;
		String nextS;
		n= Integer.parseInt(input.next());
		h= Integer.parseInt(input.next());
		k= Integer.parseInt(input.next());
		

		fill=0;
		boolean cnt=true;
		next=input.nextInt();
		while (next>=0 || fill>0) {
	
			while(true){
		
				if(fill+next<=h){fill+=next;
				
				if(input.hasNext())next=input.nextInt();
				else {next= -10;break;}
				}
				else break;
			}
			fill-=k;
			if(fill<0)fill=0;
			res++;
		}
		System.out.printf("%d\n",res);
	}
	
	static class Input{
		BufferedReader br;
		StringTokenizer st;
		InputStream is;
		
		public Input(InputStream inputStream) {
			// TODO Auto-generated constructor stub
			is=inputStream;
			br= new BufferedReader(new InputStreamReader(inputStream),32768);
		}
		
		String next()
		{
			while(st==null || !st.hasMoreElements())
			{
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		String nextString()
		{
			return next();
		}
		
	}
	

}
