import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileInput {

	static ArrayList<ArrayList<Double>> abc;
	public void read() throws NumberFormatException, IOException{
		InputStream in = new FileInputStream(new File("E:\\Eclipse\\workspace\\MDT1\\src\\a.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(in),32768);
		int allint_index;
		ArrayList<ArrayList<Double>> allinInt = new ArrayList<ArrayList<Double>>();
		ArrayList<HashMap<Double, String>> intinString=new ArrayList<HashMap<Double,String>>();
		String sst;
		StringTokenizer st=null;
		while ((st==null || !st.hasMoreElements()) &&((sst=br.readLine()) !=null)) {
			
			st=new StringTokenizer(sst);
			allint_index=0;
			if(allinInt.size()==0){
				while(st.hasMoreElements())
				{
					ArrayList<Double> a= new ArrayList<Double>();
					a.add(Double.parseDouble(st.nextToken()));
					allinInt.add(a);
				}
			}//end of creating and adding integer in arraylist firsttime
			else{
				while (st.hasMoreElements()) {
					allinInt.get(allint_index++).add(Double.parseDouble(st.nextToken()));	
				}
				
			}
			
			
		}
		
		abc=allinInt;
	
		
		
	}
	public ArrayList<ArrayList<Double>> returnAllinColumns(){
		
		return abc ;
		
	}
}
