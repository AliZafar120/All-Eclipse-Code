import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Funky_Numbers {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	//long  num=(new Scanner(new FileInputStream("E:\\Eclipse\\workspace\\Codeforces\\src\\input.txt"))).nextLong();
	long  num=(new Scanner(System.in)).nextLong();
	boolean present= false;
	long p1=(long)Math.sqrt(num),p2,p3,p4;

	for(long i=1;i<=p1;i++)
	{
		
		p2=i*(i+1)/2;
		p3=num-p2;
		if(p3>0)
		{
		p4=(long) Math.sqrt(p3*2);
		if(p4*(p4+1)==2*p3){present=true;break;}
		}

	}
	if(present)System.out.println("YES");
	else System.out.println("NO");
	

	}
	
}
