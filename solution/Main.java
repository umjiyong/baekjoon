import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Point>[] list;
	static int maxV;
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[10001];
		for(int i=0;i<list.length;i++) {
			list[i]=new ArrayList<>();
		}
		int end =0;
		for(int i=0;i<n-1;i++) {
			String [] temp = br.readLine().split(" ");
			int p = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			int d = Integer.parseInt(temp[2]);
			list[p].add(new Point(c,d));
			end=Math.max(end, c);
		}
		for(start=1;start<=end;start++) {
			maxV = Math.max(maxV, dfs(start,0));
		}
		System.out.println(maxV);
	}

	private static int dfs(int index, int dis) {
		if(list[index].size()==0) return dis; 

		ArrayList <Point> getNode = list[index];
		int max=0;
		if(start==index) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
			for(int i=0;i<getNode.size();i++) {
				int temp  = dfs(getNode.get(i).index, getNode.get(i).d+dis);
				pq.add(temp);
			}
			for(int i=0;i<2;i++) {
				if(pq.peek()!=null) {
					max+=pq.poll();
				}
			}
		} else {
			for(int i=0;i<getNode.size();i++) {
				int current=getNode.get(i).index;
				int currentDis =  getNode.get(i).d+dis;
					max = Math.max(max, dfs(current, currentDis));
			}
		}
		return max;
	}

	private static class Point{
		int index, d;
		Point(int index, int d){
			this.index=index;
			this.d=d;
		}
	}
}
