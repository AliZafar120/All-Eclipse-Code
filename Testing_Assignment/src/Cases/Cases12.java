package Cases;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;


public class Cases12 {

	public String final_string;
	public void changename(String line) {
		final_string="";
		InputStream inputStream= new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8));
		Input in=new Input(inputStream);
		//Input in= new Input(System.in);
		int len=Integer.parseInt(in.nextString()),des=Integer.parseInt(in.nextString());
		StringBuilder givenName=new StringBuilder(in.nextString());
		char a,b;
		for (int i = 0; i < des; i++) {
			a=in.nextString().charAt(0);
			b=in.nextString().charAt(0);
			for (int j = 0; j < len; j++) {
				if(a==givenName.charAt(j))givenName.setCharAt(j, b);
				else if(b==givenName.charAt(j))givenName.setCharAt(j, a);
			}
			
		}
		System.out.println(givenName);
		final_string+=givenName;
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
