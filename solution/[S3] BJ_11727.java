import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int ans[] = new int[N];
        
        if (N == 1) {
        System.out.println(1);
            return;
        }

        ans[0] = 1;
        ans[1] = 3;

        for (int i = 2; i < N; i++) {
            ans[i] = ans[i - 1] + 2 * ans[i - 2];

            if (ans[i] > 10007) {
                ans[i] %= 10007;
            }
        }

        System.out.println(ans[N - 1]);
    }
}

