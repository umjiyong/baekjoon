import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static int W,V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > i; j--) {
                bw.write(" ");
            }
            for (int j = 0; j < 2*i+1; j++) {
                bw.write("*");
            }
            bw.newLine();
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 2*N-1-2*i; j > 0; j--) {
                bw.write("*");
            }
            bw.newLine();
        }
        bw.flush();
    }
}