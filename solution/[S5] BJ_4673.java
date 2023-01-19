import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;

//        int N = Integer.parseInt(br.readLine());

        boolean [] check = new boolean [10001];

        for (int i = 1; i < 10001; i++) {
            if (checkf(i) < 10001) check [checkf(i)] = true;
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) System.out.println(i);
        }

    }

    private static int checkf(int in) {
        int num = in;
        while (in>0) {
            num += in%10;
            in/= 10;
        }
        return num;
    }
}
