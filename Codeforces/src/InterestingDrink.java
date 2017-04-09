import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.Inflater;




public class InterestingDrink {

	static int[] inps=new int[100005];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		int sn,dn,cn=0,x;
	
		sn=Integer.parseInt(in.nextString());
		for(int i=1;i<=sn;i++){inps[Integer.parseInt(in.nextString())]++;}
		for(int i=1;i<=100000;i++){inps[i]=(inps[i-1]+inps[i]);}
		
		
		dn=Integer.parseInt(in.nextString());
		
		for(int i=0;i<dn;i++){
			
		x=Integer.parseInt(in.nextString());
		if(x>100000) cn=sn;
		else cn=inps[x];
		System.out.println(cn);
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
