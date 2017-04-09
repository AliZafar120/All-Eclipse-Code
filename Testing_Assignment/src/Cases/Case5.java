package Cases;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Case5 {
	
	public ArrayList<ArrayList<Double>> rows ;
	public void processInput(String line) throws NumberFormatException, IOException {
		
	InputStream x= new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8));
	 BufferedReader br= new BufferedReader(new InputStreamReader(x));
	 	rows = new ArrayList<ArrayList<Double>>();


		
		while((line=br.readLine())!=null && line.length()!=0){
			
			if(line.indexOf(",")>=0){
			StringTokenizer st= new StringTokenizer(line,",");
			ArrayList<Double> row = new ArrayList<>();
			while (st.hasMoreElements()) {
				row.add(Double.parseDouble(st.nextToken()));
				
			}
			rows.add(row);
			
		  }
		}
		
	}
	
	}
	

