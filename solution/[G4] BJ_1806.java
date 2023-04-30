import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int [] sum;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        sum = new int[N];

        st = new StringTokenizer(br.readLine());

        sum[0] = Integer.parseInt(st.nextToken());

        for (int i = 1;  i < N; i++){
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int ans = 100001;

        if (sum[N-1]>=S){
            ans = N;
        }
        if (sum[start]>=S){
            ans = 1;
        }

        while (start < N){

            int now = sum[end]-sum[start];

            if (now < S){
                if (end != N-1){
                    end++;
                }
                else {
                    break;
                }
            }
            else{
                ans = Math.min(end-start,ans);

                start++;
            }
        }

        if (ans == 0){
            ans = 1;
        }

        if (ans == 100001) {
            ans = 0;
        }
        System.out.println(ans);

    }
}
