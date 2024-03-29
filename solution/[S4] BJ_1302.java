import java.io.*;
import java.util.*;

public class Main {

	static int num;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeMap<String,Integer> hsm = new TreeMap<>();

		int input = Integer.parseInt(br.readLine());
		int max = 0;
		String name = "z";
		
		for(int i=0; i < input; i++) {
			String key = br.readLine();
			if( hsm.containsKey(key)) {
				hsm.put(key, hsm.get(key)+1);
			}
			else {
				hsm.put(key, 1);
			}
		}
		Iterator it = hsm.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			
			if(max < hsm.get(key)) {
				max = hsm.get(key);
				name = key;
			}
		}
		bw.write(String.valueOf(name));
		bw.flush();
	}
}
