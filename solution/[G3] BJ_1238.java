import java.io.*;
import java.util.*;

public class Main {

    static int N,M,X;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [][] dis;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dis = new int [N+1][N+1];

        for (int i = 1; i < N+1; i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        for (int i = 1; i < N+1; i++){
            dis[i][i] = 0;
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            dis[start][end] = time;
        }

        for(int k = 1; k < N+1; k++){
            for (int i = 1; i < N+1; i++){
                for (int j = 1; j < N+1; j++){

                    if (dis[i][k]!=Integer.MAX_VALUE&&dis[k][j]!=Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                    }
                }
            }
        }
        int answer = -1;
        for (int i = 1; i < N+1; i++){
            answer = Math.max (answer,dis[i][X]+dis[X][i]);
        }
        System.out.println(answer);

    }
}
