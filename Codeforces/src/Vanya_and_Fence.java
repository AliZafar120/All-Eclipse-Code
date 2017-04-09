import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Vanya_and_Fence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		int n,h,count=0;
		n= Integer.parseInt(in.next());
		h= Integer.parseInt(in.next());
		for(int i=0;i<n;i++){
			int next=Integer.parseInt(in.next());
			if(next<=h)count++;
			else count+=2;
		}
		System.out.printf("%d\n",count);
		

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
