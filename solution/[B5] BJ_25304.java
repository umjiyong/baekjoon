import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int total = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            total -= Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }

        if (total==0) {
            bw.write("Yes");
        }
        else {
            bw.write ("No");
        }

        bw.flush();
    }
}
