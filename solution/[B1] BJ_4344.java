import java.util.*;
import java.io.*;

public class Main {

    static int C;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < C; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int [] score = new int[N];

            float total=0;

            for (int j = 0 ; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                total += score[j];
            }

            float avg = total/N;

            float answer = 0;
            for (int j = 0; j < N; j++) {
                if (score[j]>avg) answer++;
            }
            answer /= N;
            answer *= 100;

            System.out.printf("%.3f%%",answer);
            System.out.println();
        }
    }
}
