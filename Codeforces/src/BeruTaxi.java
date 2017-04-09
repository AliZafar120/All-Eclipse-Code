import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BeruTaxi {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		int x,y,num;
		
		x=Integer.parseInt(in.nextString());
		y=Integer.parseInt(in.nextString());
		num=Integer.parseInt(in.nextString());
		float t_F=Float.MAX_VALUE;
	
		for(int i=1;i<=num;i++){
			
			int x1=Integer.parseInt(in.nextString());
			int y1=Integer.parseInt(in.nextString());
			int v1=Integer.parseInt(in.nextString());
		float t=(float) (Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y))/(float)v1);
		if(t<t_F)t_F=t;
		}
		System.out.println(t_F);
		
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
