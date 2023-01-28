
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

        int N = sc.nextInt();
        int num = 2;

        boolean [] Primecheck = new boolean [(int)Math.sqrt(N)+1];
        for(int i = 2; i < (int)Math.sqrt(N)+1; i++) {
            if(Primecheck[i] == true) {
                continue;
            }

            for(int j = i * i; j < (int)Math.sqrt(N)+1; j = j+i) {
                Primecheck[j] = true;
            }
        }

        while (N > 1 && num <= Math.sqrt(N)) {

            if (!Primecheck[num] && (N%num==0)) {
                N /= num;
                System.out.println(num);
                continue;
            }
            num ++;
        }

        if (N!=1) {
            System.out.println(N);
        }

    }
}