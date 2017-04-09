import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Pyramid_of_Glasses {

	public static void main(String[] args) {
		
		InputStream inputStream= System.in;
		Input in=new Input(inputStream);

		int i,j,cups=0,number_of_cups,time;
		 double[][] pyramid= new double[20][20]; 
		number_of_cups= Integer.parseInt(in.next());
		time=Integer.parseInt(in.next());
		pyramid[1][1]=time;
		
		for(i=1;i<=number_of_cups;i++){
			
			for(j=1;j<=i;j++){
				if(pyramid[i][j]>=1){
					pyramid[i+1][j]+=(pyramid[i][j]-1)/2;
					pyramid[i+1][j+1]+=(pyramid[i][j]-1)/2;
					cups++;
				}
			}
			
		}
		
		
		System.out.printf("%d\n",cups);
		
		
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
