import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;




public class Wet_Shark_even_odd {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;	
		Input in=new Input(inputStream);
				
		
		int cases=Integer.parseInt(in.nextString()),temp,low=Integer.MAX_VALUE;
		long ans=0;
		while(cases-->0){
			temp=Integer.parseInt(in.nextString());
			if(temp%2==1 && low>temp)low=temp;
			ans+=temp;
			
		}
		
		if(ans%2==1)ans-=low;
		System.out.println(ans);
		
		
		
		

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
