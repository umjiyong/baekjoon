import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int M,N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            bw.write(comb(M,N)+"\n");


        }

        bw.flush();
    }

    static int comb (int n, int r){
        int ret = 1;
        for (int i = 1; i <= r; i++){
            ret *= n-i+1;
            ret /= i;
        }

        return ret;
    }
}
