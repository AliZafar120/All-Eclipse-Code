import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;


public class Squirrel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp= new Scanner(System.in);
		BigInteger n,m,z;
		BigInteger x=inp.nextBigInteger();
		n= x.subtract(new BigInteger("1"));
		z=x.subtract(new BigInteger("3"));
		m=n.multiply(z);
		m=m.add(new BigInteger("1"));
		System.out.println(m);
		

	}

}
