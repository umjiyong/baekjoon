import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int ans[] = new int [50001];
        Arrays.fill(ans,4);

        for (int i = 1; i <= (int) Math.sqrt(50000); i++){
            ans [i*i] = 1;
            for (int j = 1; j <= 50000; j++){
                if (j-i*i <= 0) {
                    continue;
                }
                ans [j] = Math.min(ans[j-i*i]+1,ans[j]);
            }
        }

        System.out.println(ans[N]);
    }
}

