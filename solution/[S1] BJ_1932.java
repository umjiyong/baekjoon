import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] num,sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int [N][N];
        sum = new int [N][N];

        StringTokenizer st;

        for (int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0]=num[0][0];
        for (int i = 1; i < N; i++){
            for (int j = 0; j <= i; j++){
                sum[i][j] = Math.max(sum[i][j],sum[i-1][j]+num[i][j]);
                if(j==0){
                    continue;
                }
                sum[i][j] = Math.max(sum[i][j],sum[i-1][j-1]+num[i][j]);
            }
        }
        int ans=0;

        for (int i = 0; i < N; i++){
            ans = Math.max(ans,sum[N-1][i]);
        }

        System.out.println(ans);



    }
}
