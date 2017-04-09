import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Chocolate {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		
		//InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		long n=Integer.parseInt(in.nextString());

		
		long count=1;
		long zerc=0;
		long temp=0,prevtemp=-1,cnt;
		for(long i=0;i<n;i++){
			if(prevtemp==-1)temp=Integer.parseInt(in.nextString());
			else {temp=1;i-=1;}
			if(temp==1){
				cnt=0;
				do{
					cnt++;
					if(i==n-1)break;
					temp=Integer.parseInt(in.nextString());
					i++;
					
				}while(temp==0);
				if(temp==1)count*=cnt;
				prevtemp=1;
			}
			if(i==zerc && temp==0){
				zerc++;
			}
		}
		if(zerc!=n)System.out.println(count);
		else System.out.println(0);

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
