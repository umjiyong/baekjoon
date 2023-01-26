
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());

        int M = sc.nextInt();
        N = sc.nextInt();
        boolean[] Primecheck = new boolean[10001];
        Primecheck[1]=true;

        for (int i = 2; i <= Math.sqrt(10001); i++) {

            if (Primecheck[i] == true) {
                continue;
            }

            for (int j = i * i; j < 10001; j = j + i) {
                Primecheck[j] = true;
            }
        }

        int sum = 0;
        int min = -1;
        for (int i = M; i<=N; i++) {
            if (!Primecheck[i]){
                if (min == -1) min = i;
                sum += i;
            }
        }

        if (min == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);

    }
}
