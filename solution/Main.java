import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long [] sum = new long [N+1];
        sum[0]=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
              sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(sum[end]-sum[start-1])+"\n");
        }
        bw.flush();
    }
}

