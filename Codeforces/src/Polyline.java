import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Polyline {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		
		int x1,x2,x3,y1,y2,y3;
		x1=Integer.parseInt(in.nextString());
		y1=Integer.parseInt(in.nextString());
		
		x2=Integer.parseInt(in.nextString());
		y2=Integer.parseInt(in.nextString());
		
		x3=Integer.parseInt(in.nextString());
		y3=Integer.parseInt(in.nextString());
		
		
		if((x1==x2 && x2==x3)||(y1==y2 && y2==y3))
			System.out.println(1);
		else if((x1==x2 || x1==x3) ||(y1==y2 || y1==y3))System.out.println(2);
		else System.out.println(3);

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
