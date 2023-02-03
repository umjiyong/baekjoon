import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] answer = new int [N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer [i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(answer);

       System.out.println(answer[N-k]);

    }
}
