import java.util.*;

public class Main {
	
		static int a, b, count, num;
		static int answer=0; 
		public static void main(String[] args) {
            
		Scanner scan = new Scanner(System.in);
		int num = 0;
		num = scan.nextInt();
		
		a = scan.nextInt();
		b = scan.nextInt();
		count=scan.nextInt();

		int[][] relation=new int[count][2];
		for(int i=0;i<count;i++) {
			relation[i][0]=scan.nextInt();
			relation[i][1]=scan.nextInt();
		}
		
		boolean[] visit=new boolean[count];
	
		for(int i=0;i<count;i++) {
			if(a==relation[i][0] && !visit[i])
				dfs(relation,visit,relation[i][1],0,i);
			else if(a==relation[i][1] && !visit[i])
				dfs(relation,visit,relation[i][0],0,i);
		}
		if(answer==0) answer=-1;
		System.out.println( answer);
		
	}
	
	static void dfs(int[][] relation, boolean[] visit, int start, int sum, int index) {
		if(start==b) { answer=sum+1; return;}
		
		visit[index]=true;
		
		if(relation[index][1]==b) { answer=sum+1; return;}
		
		for(int i=0;i<count;i++) {
			if(start==relation[i][0] && !visit[i]) {
				dfs(relation,visit,relation[i][1],sum+1,i);
			}
			if(start==relation[i][1] && !visit[i])
				dfs(relation,visit,relation[i][0],sum+1,i);
		}
	}
}
