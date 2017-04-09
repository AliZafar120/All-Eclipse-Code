
public class Data {
	
	String className;
	int size;
	int data[];
	
	public Data(String line) {
		// TODO Auto-generated constructor stub
		String arr[] = line.split(",");
		size = arr.length;
		data = new int[size];
		className = arr[0];
		for(int i=1; i<size; i++){
			data[i] = Integer.parseInt(arr[i]);
		}
	}
}
