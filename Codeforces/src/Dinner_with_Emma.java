import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Dinner_with_Emma {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		
		int n=Integer.parseInt(in.nextString());
		int m=Integer.parseInt(in.nextString());
		int min,temp=0,prevmin=0;
		
		
		for(int i=0;i<n;i++)
		{
			min=Integer.MAX_VALUE;
			for(int j=0;j<m;j++){
				temp=Integer.parseInt(in.nextString());
				if(temp<min)min=temp;
			}
			
			
			if(min>prevmin){
				prevmin=min;
			}
			
		}
		
		System.out.println(prevmin);
		
		

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
