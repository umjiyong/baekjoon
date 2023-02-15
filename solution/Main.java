import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        int max = 0;
        int min = 1000001;

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }

        System.out.println(max*min);

    }
}