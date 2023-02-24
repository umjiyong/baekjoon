import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static int W,V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int basket [] = new int[N];

        for (int i = 0; i < N; i++) {
            basket [i] = i + 1;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = basket[a-1];
            basket[a-1] = basket [b-1];
            basket[b-1] = temp;
        }

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(basket[i])+" ");
        }
        bw.flush();
    }
}
