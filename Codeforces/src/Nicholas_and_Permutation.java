import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Nicholas_and_Permutation {
	
	public static void main(String[] args) {
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);
		int total= Integer.parseInt(in.next());
		int maxpos=999,minpos=0;
		for(int i =1; i<=total;i++){
			int number=Integer.parseInt(in.next());
			if(number==1) minpos=i;
			else if(number==total) maxpos=i;
		}
		
		int difpos=Math.abs(maxpos-minpos);
		
		if(maxpos-1>=0 && minpos!=1 && minpos-1>difpos)difpos=minpos-1;
		if(maxpos-1>=0 &&  total-minpos>difpos)difpos=total-minpos;
		
		
		if(minpos-1>=0 && maxpos!=1 && maxpos-1>difpos)difpos=maxpos-1;
		if(minpos-1>=0 &&  total-maxpos>difpos)difpos=total-maxpos;
		System.out.println(difpos);
		
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
