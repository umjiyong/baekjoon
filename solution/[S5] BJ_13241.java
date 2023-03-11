import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long cA = A;
        long cB = B;
        while (cA!=cB) {

            if (cA > cB) {
                cA -= cB;
            }
            else {
                cB -= cA;
            }
        }
        System.out.println(A/cA*B);
    }
}
