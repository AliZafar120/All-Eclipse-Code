import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Vasya_and_String {

	public static void main(String[] args) {
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		
		int length_of_string,max_change,a_count=0,b_count=0,result=0,index=0;
		String given_string;
		length_of_string=Integer.parseInt(in.next());
		max_change=Integer.parseInt(in.next());
		given_string= in.next();	
		for(int i=0;i<length_of_string;i++){
			
			if(given_string.charAt(i)=='a'){a_count++;}
			else {b_count++;}
			
			if(Math.min(a_count, b_count)>max_change){
				if(given_string.charAt(index)=='a')a_count--;
				else b_count--; 
				index++;
			}
			else result=Math.max(result,a_count+b_count);
			
			
		}
	 System.out.printf("%d\n",result);
		
				
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
