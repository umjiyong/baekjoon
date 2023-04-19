import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

    static int N,M;

       static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        make(1,0, "");

        bw.flush();
    }
    static void make(int num, int len, String str) throws IOException {

        if (len == M) {
            bw.write(str);
            bw.newLine();
            return;
        }

        for (int i = num; i <= N; i++){
            make(i+1,len+1, str+i+" ");
        }
    }

}


