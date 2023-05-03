import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] sum;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sum = new int [N][N];

        st = new StringTokenizer(br.readLine());
        sum[0][0] = Integer.parseInt(st.nextToken());

        for (int j = 1; j < N; j++){
            sum[0][j] = sum[0][j-1]+Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            sum[i][0] = sum[i-1][0]+Integer.parseInt(st.nextToken());

            for (int j = 1; j < N; j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+Integer.parseInt(st.nextToken());
            }
        }



        for (int i = 0 ; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            int ans = 0;
            ans += sum[x2][y2];
            if (x1!=0){
                ans-= sum[x1-1][y2];
            }
            if (y1!=0){
                ans-= sum[x2][y1-1];
                if(x1!=0){
                    ans+=sum[x1-1][y1-1];
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();


    }
}
