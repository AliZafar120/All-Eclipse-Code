import java.util.Arrays;
import java.util.Scanner;


public class Primes_or_Palindromes {

	
	static int []twins= new int[100000];
	static boolean []primes= new boolean[20000000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeseive();
		int num=(new Scanner(System.in)).nextInt();
		System.out.println(twins[num-1]+" "+twins[num-1]+2);
		
	}
	
	static void primeseive()
	{
		Arrays.fill(primes, true);
		primes[0]=primes[1]=false;
		for (long i = 2,j=0,k=0; i <=20000000  ; i++) {
			if(primes[(int) i])
			{
				if(primes[(int)i-2]==true)twins[(int) k++]=(int) (i-2);
				j=i+i;
				while (j<=20000000) {
					primes[(int) j]=false;
					j+=i;
				}
			}
			
		}
	}

}
