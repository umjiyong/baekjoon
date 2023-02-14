import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a==0) break;

            if (a > b) {


                if (a % b == 0) {
                    bw.write("multiple\n");
                } else {
                    bw.write("neither\n");
                }
            }

            else{
                if (b % a == 0) {
                    bw.write("factor\n");
                }
                else{
                    bw.write("neither\n");
                }
            }
        }
        bw.flush();
    }
}