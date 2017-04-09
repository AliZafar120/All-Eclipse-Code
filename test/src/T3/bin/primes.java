package T3.bin;

import java.util.ArrayList;

public class primes {

	
	public static void main(String[] args) {
		
		Boolean isPrime;
		ArrayList<Integer>primes = new ArrayList<Integer>();
		for(int i=2;i<100;i++){
			isPrime=true;
			for (Integer prime : primes) {
				if(i%prime==0){isPrime=false; break;}
				
			}
			if(isPrime)primes.add(i);
			
			
		}
		System.out.println(primes.size());
	}
}
