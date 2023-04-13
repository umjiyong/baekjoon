import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Node(to, from, value));
        }

        parents = new int[N + 1];
        for (int i=1; i <= N; i++) { // 부모를 자기 정보로 채워넣기
            parents[i] = i;
        }

        int total =0;
        // 간선 하나씩 조회 (비용이 작은 간선부터)
        for(int i=0; i< M; i++) {
            Node node = pq.poll();
            int rx = find(node.to);
            int ry = find(node.from);

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(!isSameParent(rx, ry)) {
                total += node.value;
                union(node.to,node.from);
            }
        }
        bw.write(String.valueOf(total));
        bw.flush();

    }

    static class Node implements Comparable<Node> {

        int to;
        int from;
        int value;

        public Node (int to, int from, int value){
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) { // 오름차순
            return this.value - o.value;
        }
    }

    static int find(int x){
        if (parents[x] == x){ // 자기 자신이 부모면 return
            return x;
        }
        else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union (int x, int y){
        x = find(x);
        y = find(y);

        if (x < y) { // 작은 쪽이 부모가 됨
            parents[y] = x;
        }
        else {
            parents[x] = y;
        }
    }

    static boolean isSameParent(int rx, int ry) {
        if(rx == ry) return true;
        return false;
    }

}

