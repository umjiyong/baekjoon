import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = a;
            int y = b;
            while (x!=y) {
                if (x>y) x -=y;
                else y-= x;
            }

            System.out.println(a*b/x);

        }
    }
}