import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int W,V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] ans = new int [N];

        for (int i = 0; i < N; i++){
            ans [i] = i+1;
        }

        for (int l = 0; l < M; l++){
            st = new StringTokenizer(br.readLine());

            int i,j,k;

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int [] temp = new int [j-i+1];

            for (int m = 0; m < j-i+1; m++){
                temp[m] = ans[i+m-1];
            }

            for (int m = 0; m < j-k+1; m++){
                ans[i-1+m] = temp[k-i+m];
            }
            for (int m = 0; m < k-i; m++){
                ans[i+j-k+m] = temp[m];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(ans[i]+" ");
        }

        bw.flush();

    }
}