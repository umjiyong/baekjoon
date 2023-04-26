import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean [] visit;
    static int workA[] , workB[];
    static int dp [][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        workA = new int [N];
        workB = new int [N];
        dp = new int[N][62501];

        int sum = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            workA[i] = Integer.parseInt(st.nextToken());
            workB[i] = Integer.parseInt(st.nextToken());
            sum += workA[i];
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][sum]=0;
        dp[0][sum-workA[0]] = workB[0];

        for (int i = 0; i < N-1; i++){
            for (int j = 0; j < 62501; j++){
                if(dp[i][j]!=Integer.MAX_VALUE) {
                    // B가 일을 맡지 않았을 때
                    dp[i + 1][j] = dp[i][j];
                    // B가 일을 맡았을 때
                    dp[i + 1][j - workA[i + 1]] = Math.min(dp[i + 1][j - workA[i + 1]], dp[i][j] + workB[i + 1]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 62501; i++){
            ans = Math.min(ans,Math.max(i,dp[N-1][i]));
        }
        System.out.println(ans);





    }
}