import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r;
	static int[] items, results;
	static List<Vertex>[] graph;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
	
		graph = new ArrayList[n + 1];
		items = new int[n + 1];	
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Vertex>();
			items[i] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int weight = Integer.valueOf(st.nextToken());
			graph[from].add(new Vertex(to, weight));
			graph[to].add(new Vertex(from, weight));
		}
		
		results = new int[n + 1];
		int result = 0;
		for(int i = 1; i <= n; i++) {
			Arrays.fill(results, Integer.MAX_VALUE);
			result = Math.max(result, dijkstra(i));
		}
		
		System.out.println(result);
	}
	
	static int dijkstra(int start) {
		boolean[] visited = new boolean[n + 1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		int result = 0;
		pq.offer(new Vertex(start, 0));
		results[start] = 0;
		
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			if(visited[v.end]) {
				continue;
			}
			
			if(v.weight > results[v.end]) {
				continue;
			}
			
			visited[v.end] = true;
			
			for(Vertex nextV : graph[v.end]) {

				if(!visited[nextV.end] && nextV.weight + results[v.end] < results[nextV.end]) {
					results[nextV.end] = nextV.weight + results[v.end];
					pq.offer(new Vertex(nextV.end, results[nextV.end]));
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(results[i] <= m) {
				result += items[i];
			}
		}
		
		return result;
	}
}

class Vertex implements Comparable<Vertex> {
	int end;
	int weight;

	Vertex(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Vertex o) {
		if(this.weight < o.weight) {
			return -1;	
		}
		
		return 1;
	}
	
}
