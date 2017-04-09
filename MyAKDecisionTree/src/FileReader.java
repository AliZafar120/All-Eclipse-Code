import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class FileReader {
	public static final String PATH_TO_DATA_FILE = "E:\\Eclipse\\workspace\\MyAKDecisionTree\\src\\input.txt";
	
	public ArrayList<ArrayList<Double>> getRecords(){
		BufferedReader reader = null;
		DataInputStream dis = null;
		ArrayList<ArrayList<Double>> data=new ArrayList<ArrayList<Double>>();
		try {
			File f = new File(PATH_TO_DATA_FILE);
	        FileInputStream fis = new FileInputStream(f); 
	        reader = new BufferedReader(new InputStreamReader(fis));
	        String line;
	        while((line=reader.readLine())!=null){
	        	StringTokenizer st = new StringTokenizer(line, ",");
	        	ArrayList<Double> arrayList=new ArrayList<Double>();
	        	int l=st.countTokens();
	        	for(int i=0;i<l;i++){
	        		arrayList.add(Double.parseDouble(st.nextToken()));
	        	}
	        	data.add(arrayList);
	        }
			
		} catch (Exception e) {
			System.out.println("Uh oh, got an IOException error: " + e.getMessage());
		}
		return data;
	}
}
