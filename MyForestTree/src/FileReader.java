import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileReader {
	
	private ArrayList<ArrayList<Double>> rows;
	private File toread;
	public FileReader(String filename) throws IOException {
		// TODO Auto-generated constructor stub
		toread=new File(filename);
		rows=new ArrayList<ArrayList<Double>>();
		processInput();
	}
	
	private void processInput() throws IOException{
	BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(toread)));
	String line;
	while((line=br.readLine())!=null && line.length()!=0){
		StringTokenizer st= new StringTokenizer(line,",");
		ArrayList<Double> row = new ArrayList<>();
		while (st.hasMoreElements()) {
			row.add(Double.parseDouble(st.nextToken()));
			
		}
		rows.add(row);
		
	  }
	
	}
	
	public ArrayList<ArrayList<Double>> get_processed_input(){
		return rows;
	}
	

}
