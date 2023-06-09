import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] s = br.readLine().split("");
       
       if(Arrays.asList(s).contains("0")){
           int[] arr = new int[s.length];
    	   int sum = 0;
           for(int i = 0; i < arr.length; i++) {
        	   arr[i] = Integer.parseInt(s[i]);
        	   sum += arr[i];
           }
           Arrays.sort(arr);
           if(sum % 3 == 0)
        	   for(int i = arr.length-1; i > -1; i--) {
        		   System.out.print(arr[i]);
           }
           else
        	   System.out.println(-1);        	   
       }
       else
    	   System.out.println(-1);
    }
}
