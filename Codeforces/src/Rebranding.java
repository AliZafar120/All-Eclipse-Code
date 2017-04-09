import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Rebranding {

public static void main(String[] args) throws FileNotFoundException {
	Input in=new Input(new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"));
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
	
}

static class Input{
	InputStream ins;
	BufferedReader br;
	StringTokenizer st;
	
	public Input(InputStream inputStream) {
		// TODO Auto-generated constructor stub
	ins=inputStream;
	br= new BufferedReader(new InputStreamReader(inputStream),32768);
	}
	
	String  next()
	{
		while (st==null || !st.hasMoreElements()) {
			try {
				st= new StringTokenizer(br.readLine());
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
