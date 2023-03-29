import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int [][] map;
    static boolean visited [][];
    static int N,M;
    static int [] dr = {0,0,-1,1};
    static int [] dc = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map [i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                tetr(i,j,1,0);
            }
        }

        System.out.println(answer);
    }

    private static void tetr(int r, int c, int count, int sum) {
        if (visited[r][c]) { // 기방문
            return;
        }

        visited[r][c] = true;
        sum += map[r][c];

        if (count == 4) { // 4개 채웠음
            answer = Math.max (answer,sum);
            visited [r][c] = false;
            return;
        }

        if (count == 2){
            for (int i = 0; i < 4; i++){
                for (int j = i+1; j < 4; j++){
                    int nr1 = r+dr[i];
                    int nc1 = c+dc[i];
                    int nr2 = r+dr[j];
                    int nc2 = c+dc[j];

                    if (nr1 >= N || nc1 >=M || nr1 < 0|| nc1 <0){
                        continue;
                    }

                    if (nr2 >= N || nc2 >=M || nr2 < 0|| nc2 <0){
                        continue;
                    }

                    if (visited[nr1][nc1] || visited [nr2][nc2]) {
                        continue;
                    }

                    sum += map[nr1][nc1];
                    sum += map[nr2][nc2];
                    answer = Math.max (answer,sum);
                    sum -= map[nr1][nc1];
                    sum -= map[nr2][nc2];
                }
            }
        }

        for (int i = 0; i < 4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if (nr >= N || nc >=M || nr < 0|| nc <0){
                continue;
            }

            tetr (nr,nc,count+1,sum);
        }
        visited[r][c] = false;
    }
}

