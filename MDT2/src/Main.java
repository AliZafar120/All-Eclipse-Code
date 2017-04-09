

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private static Node Root = new Node();
	private static Scanner in;
	
	public static void main(String[] args) throws IOException {
		readData();
		Root.resolve();
	}
	
	private static void readData() throws IOException{
		in = new Scanner(new File("E:\\Eclipse\\workspace\\MDT2\\src\\balance-scale.data"));
		while(in.hasNext()){
			Root.addData(new Data(in.nextLine()));
		}
		Root.resolve();
		
		
		// begin query part
		
		in = new Scanner(System.in);
		int a[] = new int[5];
		a[1] = in.nextInt();
		a[2] = in.nextInt();
		a[3] = in.nextInt();
		a[4] = in.nextInt();
		String res = Root.query(a);
		System.out.println(res);
		
		// end query part
	}
	
}
