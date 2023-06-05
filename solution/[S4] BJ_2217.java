import java.io.*;
import java.util.*;

public class Main {
    
    public static Integer N;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
	    Integer rope[] = new Integer [N];
        
		for(int i=0; i<N; i++) {
			rope[i] = Integer.valueOf(br.readLine());
		}
        
		Arrays.sort(rope, Comparator.reverseOrder());
        
		int max = 0;
        
		for(int i=0; i<N; i++) {
			max = Math.max(rope[i]*(i+1), max);
		}
        
		System.out.println(max);
	}
}
