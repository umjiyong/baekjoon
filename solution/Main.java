import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] graph=new int[n][n];
		for(int i=0;i<n;i++) {
			String part=br.readLine();
			for(int j=0;j<n;j++) {
				if(part.charAt(j)=='Y') {
					graph[i][j]=1;
				}
				else {
					graph[i][j]=9999;
				}
			}
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j||i==k||j==k) {continue;}
					else if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j]=graph[i][k]+graph[k][j];
					}
				}
			}
		}
		
		int[] ans_list=new int[n];
		
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(graph[i][j]<=2) {
					count++;
				}
			}
			ans_list[i]=count;
		}
		Arrays.sort(ans_list);
		System.out.println(ans_list[n-1]);
	}
}
