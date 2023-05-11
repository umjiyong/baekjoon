import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static int [] parent;
        static boolean [] visited;
        static List<Integer> [] connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int [N+1];
        visited = new boolean[N+1];
        connected = new ArrayList [N+1];

        for (int i = 1 ; i < N+1; i++){
            connected[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connected[a].add(b);
            connected[b].add(a);
        }

        check(1);

        for (int i = 2; i < N+1; i++){
            bw.write(parent[i]+"\n");
        }
        bw.flush();


    }
    static void check(int now){
        visited[now] = true;
        for(int i : connected[now]){
            if(!visited[i]){
                parent[i]=now;
                check(i);
            }
        }

    }
}
