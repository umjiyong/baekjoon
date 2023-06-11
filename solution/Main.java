import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long s = Long.parseLong(br.readLine());	
		long sum = 0;							
		int i = 0;								
		
		while(sum < s) {						
			i++;
			sum += i;
		}
		
		if(sum > s) {						
			i--;								
		}
		
		System.out.print(i);

	}
	
}
