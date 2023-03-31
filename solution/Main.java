import java.io.*;
import java.util.*;

public class Main {


    static int [][] map;
    static boolean visited [][];
    static int N;
    static int [] dr = {0,0,-1,1};
    static int [] dc = {1,-1,0,0};
    static PriorityQueue<Integer> ans_list = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int [N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            for (int j = 0; j < N; j++){
                map [i][j] = temp.charAt(j)-48;
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (visited[i][j]) {
                    continue;
                }
                if(map[i][j]==1){
                bfs (i,j);
                }
            }
        }
        int size = ans_list.size();
        bw.write(size+"\n");
        for (int i = 0; i < size; i++){
            bw.write(ans_list.poll()+"\n");
        }
        bw.flush();

    }

    private static void bfs(int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r,c));
        visited[r][c]=true;
        int count = 0;

        while (!q.isEmpty()){
            Pos temp_pos = q.poll();
            int temp_r = temp_pos.r;
            int temp_c = temp_pos.c;

            count++;
            for (int i = 0; i < 4; i++){
                int nr = temp_r+dr[i];
                int nc = temp_c+dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0 ) {
                    continue;
                }
                visited[nr][nc] = true;
                q.add(new Pos(nr,nc));
            }
        }
        ans_list.add(count);
    }
    static class Pos {
        int r;
        int c;
        Pos (int x, int y){
            this.r = x;
            this.c = y;
        }
    }
}

