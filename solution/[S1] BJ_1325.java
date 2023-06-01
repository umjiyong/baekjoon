import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[N+1];
        arr = new ArrayList[N +1];
        for(int i=1; i<=N; i++){ 
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
        }
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1]; 
            BFS(i);
        }
        int max = 0;
        for(int i=1; i<=N; i++){
            if(answer[i] > max) max = answer[i];
        }
        for(int i=1; i<=N; i++){
            if(answer[i] == max){
                System.out.print(i +" ");
            }
        }

    }
    static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int current = q.poll(); 
            for(int i: arr[current]){
                if(!visited[i]){
                    answer[i] ++;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
