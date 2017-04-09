import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Pawnchess {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//InputStream inputStream= new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt");
		InputStream inputStream= System.in;
		
		Input in=new Input(inputStream);
		int[][] white=new int[9][9];
		int[][] black=new int[9][9];
		int shortest=-1;
		Boolean absent;
		Boolean Wwin = null;
		
		for(int i=0;i<8;i++)
		{
			String s = in.nextString();
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='W')white[i+1][j+1]=1;
				else if(s.charAt(j)=='B')black[i+1][j+1]=1;
			
				
			}
		}
		for(int i=1;i<9;i++)
		{
			for(int j=1;j<9;j++)
			{
				if(black[i][j]==1)
				{
					absent=true;
					for(int k=i+1;k<9;k++)
						{if(white[k][j]==1){absent=false;break;}}
					if(absent &&(shortest==-1 || shortest>8-i))
						{shortest=8-i;Wwin=false;}
				}
				else if(white[i][j]==1)
				{
					absent=true;
					for(int k=i-1;k>0 ;k--)
					{
						if(black[k][j]==1){absent=false;break;}
					}
					if(absent &&(shortest==-1 || shortest>=i-1))
						{shortest=i-1;Wwin=true;}
				}
				
				
			}
			
		}
		
		if(Wwin==true)System.out.println("A");
		else System.out.println("B");

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



