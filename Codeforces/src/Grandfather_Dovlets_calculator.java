import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Grandfather_Dovlets_calculator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		int a= Integer.parseInt(in.nextString());
		int b= Integer.parseInt(in.nextString());
		long cnt = 0;
		int nums[]={6,2,5,5,4,5,6,3,7,6};
		int y;
		for(int i=a;i<=b;i++)
		{
			y=i;
			while(y>0){
				cnt+=nums[y%10];
				y/=10;
				
			}
			
		}
			
		
		System.out.println(cnt);
	
		
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
