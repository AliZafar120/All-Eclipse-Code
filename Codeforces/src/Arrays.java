import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;


public class Arrays {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//input inp = new input(System.in);
		input inp = new input( new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"));
		int n1,n2,k,m;
		ArrayList<Integer> a1= new ArrayList<Integer>();
		ArrayList<Integer> a2= new ArrayList<Integer>();
		n1=Integer.parseInt(inp.next());
		n2=Integer.parseInt(inp.next());
		k=Integer.parseInt(inp.next());
		m=Integer.parseInt(inp.next());
		for (int i = 0; i < n1; i++) {
			a1.add(Integer.parseInt(inp.next()));
		}
		for (int i = 0; i < n2; i++) {
			a1.add(Integer.parseInt(inp.next()));
		}

	}
	
	
	static class input
	{
		BufferedReader br;
		StringTokenizer st;
		
		public input(InputStream ins) {
			// TODO Auto-generated constructor stub
		br = new BufferedReader(new InputStreamReader(ins));
		}
		
		String next()
		{
			try {
				st= new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st.nextToken();
		}
	
	}

}
