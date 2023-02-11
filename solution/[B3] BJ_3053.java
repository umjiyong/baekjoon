import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        System.out.printf("%.6f%n%.5f", Math.pow(N,2)*Math.PI
                ,Math.pow(2*N,2)/2);

    }
}
