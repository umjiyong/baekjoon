import java.io.*;
import java.util.*;

public class Main {

    static List<Edge>[] eList;
    static int [][] distance;
    static int fv,sv;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        eList = new List[N+1];
        distance = new int[3][N+1];

        for (int i = 1; i < N+1; i++){
            eList[i] = new ArrayList<>();
        }


        for (int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int tempFrom = Integer.parseInt(st.nextToken());
            int tempTo = Integer.parseInt(st.nextToken());
            int tempVal = Integer.parseInt(st.nextToken());

            eList[tempFrom].add(new Edge(tempTo,tempVal));
            eList[tempTo].add(new Edge(tempFrom,tempVal));
        }

        st = new StringTokenizer(br.readLine());

        fv = Integer.parseInt(st.nextToken());
        sv = Integer.parseInt(st.nextToken());

        for (int i=0; i<3; i++){
            dij(i);
        }

        int route1 = distance[0][fv]+distance[1][sv]+distance[2][N];
        int route2 = distance[0][sv]+distance[2][fv]+distance[1][N];

        int answer = Math.min(route1,route2);

        if (answer > 2400000){
            answer = -1;
        }

        System.out.println(answer);

    }

    private static void dij(int i) {

        int start = 0;
        switch(i){
            case 0 : start = 1;
            break;
            case 1 : start = fv;
            break;
            case 2 : start = sv;
            break;
            default: break;
        }

        Arrays.fill(distance[i],2400000);
        distance[i][start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));

        while (!pq.isEmpty()){
         Edge now = pq.poll();

         if (now.value > distance[i][now.to]){
             continue;
         }

         for (Edge next : eList[now.to]){
             if (next.value + distance[i][now.to] < distance[i][next.to]){
                 distance[i][next.to] = next.value + distance[i][now.to];
                 pq.add(new Edge(next.to,distance[i][next.to]));
             }
         }

        }
    }

    static class Edge implements Comparable<Edge>{
        int to;
        int value;

        public Edge (int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo (Edge o){
            return this.value - o.value;
        }
    }

}





