import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());





        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            BigInteger bi = new BigInteger(String.valueOf(num));

            if (bi.isProbablePrime(1)) {
                System.out.println(num);
            } else {
                System.out.println(bi.nextProbablePrime());
            }
        }







    }


}