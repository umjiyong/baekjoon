import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M, W;
    static int[] dist;
    static ArrayList<ArrayList<Road>> a;
    static final int INF = 100000000;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
 
            dist = new int[N + 1];
            a = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                a.add(new ArrayList<>());
            }
 
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
 
                if (i < M) { 
                    a.get(start).add(new Road(end, weight));
                    a.get(end).add(new Road(start, weight));
                } else {
                    a.get(start).add(new Road(end, -weight));
                }
            }
 
            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0; 
        boolean update = false;
        for (int i = 1; i < N; i++) {
            update = false;
 
            for (int j = 1; j <= N; j++) {
                for (Road road : a.get(j)) {
                    if (dist[road.end] > dist[j] + road.weight) {
                        dist[road.end] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Road road : a.get(i)) {
                    if (dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
    
     
   static class Road {
    int end;
    int weight;
 
    Road(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
   }
 
 
}
