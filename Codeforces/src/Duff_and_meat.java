import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Duff_and_meat {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		InputStream inputStream= System.in;
		Input inp = new Input(inputStream);
		int cases=Integer.parseInt(inp.nextString());
		int minprice=Integer.MAX_VALUE,price,demand;
		long exp=0;
		
		for (int i = 0; i < cases; i++) {
			demand=Integer.parseInt(inp.nextString());
			price=Integer.parseInt(inp.nextString());
			if(minprice>price)minprice=price;
			exp+=minprice*demand;
		}
		System.out.println(exp);

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
