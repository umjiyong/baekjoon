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

        for (int i = 0 ; i < N/4 ; i++) {
            bw.write( "long ");
        }
        if (N%4!=0) {
            bw.write( "long ");
        }
        bw.write("int");
        bw.flush();
    }
}