import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String S = br.readLine();

        char pre = 'f';
        int ans = 0;
        int count = 0;
        for (int i = 0; i < M; i++){

            char temp = S.charAt(i);

            if (temp == pre) {
                if (count > 2*N) {
                ans += (count - 2 * N + 1) / 2;
                }

                if (temp == 'I') {
                    count = 1;
                }
                else {
                    count = 0;
                }
            }
            else{
            count ++;
            }
            pre = temp;
        }
        if (count > 2*N) {
            ans += (count - 2 * N + 1) / 2;
        }
        System.out.println(ans);
    }
}

