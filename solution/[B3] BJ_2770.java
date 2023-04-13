import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int [] coin = {25,10,5,1};

        for (int i = 0 ; i < T ; i++) {
            int C = Integer.parseInt(br.readLine());

            for (int c : coin) {
                bw.write(C / c + " ");
                C %= c;
            }

            bw.newLine();
        }
        bw.flush();


    }
}

