import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class professor_guzkis_robot {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		
		int x1=Integer.parseInt(in.nextString());
		int y1=Integer.parseInt(in.nextString());
		int x2=Integer.parseInt(in.nextString());
		int y2=Integer.parseInt(in.nextString());
		int temp=0;
		if(x1>x2)temp=x1-x2;
		else {
			temp=x2-x1;
		}
		
		if(y1>y2 && y1-y2>temp)temp=y1-y2;
		else if (y2>y1 && y2-y1>temp)temp=y2-y1;
		
		System.out.println(temp);

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
