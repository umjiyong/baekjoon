import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] list;
    static boolean [] visited;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[to].add(new Node(from,value));
            list[from].add(new Node(to,value));
        }

        prim(3);
        System.out.println(total);
    }

    static class Node implements Comparable<Node> {

        int to;
        int value;

        public Node (int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) { // 오름차순
            return this.value - o.value;
        }
    }

    static void prim(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            Node p = pq.poll();
            int node = p.to;
            int weight = p.value;

            if(visited[node]) continue;
            visited[node]= true;
            total += weight;

            for(Node next : list[node]) {
                if(!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

    }

}

