import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        boolean [] prime = new boolean[1000001];

        prime[0]=true;
        prime[1]=true;

        for (int i = 2; i <= Math.sqrt(1000000); i++){

            if (prime [i] == true) continue;

            for(int j = i * i; j < 1000001; j = j+i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            int temp = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 2; j <= temp/2; j++) {

                if (!prime[j]&&!prime[temp-j]) {
                    count ++;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
