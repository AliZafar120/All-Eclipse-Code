import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Square {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Input inp = new Input(System.in);
		//Input inp = new Input(new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"));
		//long  num=(new Scanner(new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"))).nextLong();
		int cases=Integer.parseInt(inp.nextString());
		
		
		for (int i = 0; i < cases; i++) {
		 long num=Long.parseLong(inp.nextString());
		 long temp=1;
		 int counter=1;
		 if(num%2==0)System.out.println(4*num+1);
		 else if((num+1)%4==0) System.out.println((num+1));
		 else System.out.println(2*num+1);

		}
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
