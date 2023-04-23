import java.io.*;
import java.util.*;

public class Main {

    static int M,N;

    static int [] nums;
    static boolean[][] pal;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        nums = new int [N+1];
        pal = new boolean[N+1][N+1];

        for (int i = 1; i < N+1; i++){
            pal [i][i] = true;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i < N+1; i++){
            nums[i]= Integer.parseInt(st.nextToken());
        }

        for (int len = 2; len < N+1; len++){
            for (int i = 1; i < N-len+2; i++){
                int j = i + len - 1;
                if (nums[i]==nums[j]){
                    if (len == 2){
                        pal[i][j]=true;
                    }
                    else if(pal[i+1][j-1]){
                        pal[i][j]=true;
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(pal[start][end]) {
                bw.write(1+"\n");
            }
            else {
                bw.write(0+"\n");
            }
        }
        bw.flush();
    }
}
