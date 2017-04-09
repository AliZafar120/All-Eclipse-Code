import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;




public class The_Text_Splitting {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		InputStream inputStream= System.in;
		
		int months[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
		Input in=new Input(inputStream);
		int num=Integer.parseInt(in.nextString());
		in.nextString();
		String wOm=in.nextString();
		int ans = 0;
		if(wOm.compareTo("week")==0)
		{
			switch (num) {
			case 1:ans=(int)Math.floor((double)(366-4)/7)+1;
				
				break;
			case 2:ans=(int)Math.floor((double)(366-5)/7)+1;
				
				break;
			case 3:ans=(int)Math.floor((double)(366-6)/7)+1;
				
				break;
			case 4:ans=(int)Math.floor((double)(366-7)/7)+1;
				
				break;
			case 5:ans=(int)Math.floor((double)(366-1)/7)+1;
				
				break;
			case 6:ans=(int)Math.floor((double)(366-2)/7)+1;
				
				break;
			case 7:ans=(int)Math.floor((double)(366-3)/7)+1;
				
				break;
				
			default:
				break;
			}
			
			
			
		}
		else{
			ans=0;
			for(int i=1;i<=12;i++)
			{
				if (months[i]>=num) {
					ans++;
				}
				
			}
			
		}
		
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
