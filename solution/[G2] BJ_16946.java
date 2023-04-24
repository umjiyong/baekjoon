import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static boolean[][] map;
    static boolean[][] visited;
    static cluster[][] clusters;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int [][] answer;
    static int keyvalue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M];
        clusters = new cluster[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String info = br.readLine();
            for (int j = 0; j < M; j++) {
                if (info.charAt(j)=='1') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                searchmap(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!map[i][j]){
                    continue;
                }
                else {
                    answer[i][j] = 1;

                    List<cluster> tempcluster = new ArrayList<>();
                 for (int k = 0; k < 4; k ++){
                     int nr = i+dr[k];
                     int nc = j+dc[k];

                     if (nr < 0 || nc < 0 || nr >= N || nc >= M || clusters[nr][nc]==null){
                         continue;
                     }

                     boolean check = false;
                     for (cluster c : tempcluster){
                         if(c.key == clusters[nr][nc].key){
                          check=true;
                          break;
                         }
                     }
                     if(check) {
                         continue;
                     }
                     tempcluster.add(clusters[nr][nc]);
                 }
                 for (cluster t : tempcluster){
                     answer[i][j] += t.value;
                 }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(String.valueOf(answer[i][j]%10));
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static void searchmap(int r, int c) {
        if(visited[r][c]) {
            return;
        }
        if(map[r][c]==true){
            visited[r][c]=true;
            return;
        }
        keyvalue++;

        Queue<pos> q= new LinkedList<>();
        List<pos> clusterpos = new ArrayList<>();
        q.add(new pos(r,c));
        clusterpos.add(new pos(r,c));
        visited[r][c]=true;

        int count = 0;
        while(!q.isEmpty()){
            pos now = q.poll();
            count ++;


            for (int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc>= M){
                    continue;
                }

                if (!map[nr][nc]&&!visited[nr][nc]){ // 0이고 미방문
                    q.add(new pos(nr,nc));
                    clusterpos.add(new pos(nr,nc));
                    visited[nr][nc]=true;
                }
            }
        }

        for(pos p : clusterpos){
            clusters[p.r][p.c] = new cluster(keyvalue,count);
        }
    }

    static class pos {
        int r;
        int c;

        public pos (int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static class cluster{
        int key;
        int value;

        public cluster (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
