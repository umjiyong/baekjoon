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

        N=-1;
        boolean[] Primecheck = new boolean[246913];
        Primecheck[1]=true;

        for (int i = 2; i <= Math.sqrt(246913); i++) {

            if (Primecheck[i] == true) {
                continue;
            }

            for (int j = i * i; j < 246913; j = j + i) {
                Primecheck[j] = true;
            }
        }

        while (true) {
            N=sc.nextInt();
            if (N==0) return;
            int num = 0;

            for (int i = N+1; i<2*N+1; i++){
                if (!Primecheck[i]) num++;
            }

            System.out.println(num);
        }
    }
}
