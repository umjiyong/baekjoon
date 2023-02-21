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

        bw.write(Long.toString(Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken())));
        bw.flush();
    }
}
