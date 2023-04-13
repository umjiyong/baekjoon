import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    static List<Node>[] connect;
    static int[] distance;
    static boolean[] visited;
    static int total = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connect = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            connect[a].add(new Node(a, b, value));
            connect[b].add(new Node(b, a, value));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        dij(1);
        System.out.println(total);
        System.out.print(sb.toString());

    }

    private static void dij(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, start, 0));

        while (!pq.isEmpty()) {
            Node tempNode = pq.poll();

            if (tempNode.value > distance [tempNode.to]){
                continue;
            }

            if (tempNode.from != tempNode.to) {
                sb.append(tempNode.from + " " + tempNode.to + "\n");
                total++;
            }


            for (Node next : connect[tempNode.to]) {
                if (next.value + distance[tempNode.to] < distance[next.to]) { // 개선이 될 경우.
                    distance[next.to] = next.value + distance[tempNode.to];
                    pq.add(new Node(tempNode.to,next.to,next.value + distance[tempNode.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}