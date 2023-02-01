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

        N=sc.nextInt();

        for (int i = 0; i < N; i++){
            int temp = sc.nextInt();
            for (int j = temp/2; j > 0; j--) {
                if (!Primecheck[j]&&!Primecheck[temp-j]) {
                    System.out.println(j + " " + (temp - j));
                    break;
                }
            }
        }

    }
}
