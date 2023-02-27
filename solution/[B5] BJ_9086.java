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

        for (int i = 0 ; i < N; i++) {
            String str = br.readLine();
            bw.write(str.charAt(0));
            bw.write(str.charAt(str.length()-1)+"\n");
        }

        bw.flush();

    }
}
