import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int t[] = new int[n + 2];
		int p[] = new int[n + 2];
		int dp[] = new int[n + 2];	

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());	
			p[i] = Integer.parseInt(st.nextToken());	
		}
		
		int max = 0;
		
		for(int i=1;i<n+2;i++) {
			if(t[i] <= n+1)
				dp[i] = Math.max(dp[i], max);
				
				if(i+t[i]<=n+1)
					dp[i+t[i]] = Math.max(dp[i+t[i]], p[i]+dp[i]); 
				
				max = Math.max(dp[i], max);	
		}	
        
		System.out.println(max);
	}
}
