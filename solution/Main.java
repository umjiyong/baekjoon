import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cm = M;
            int cn = N;

            while (cm != cn) {
                if (cm > cn) {
                    cm -= cn;
                } else {
                    cn -= cm;
                }
            }

            int ans = -1;

            for (int j = 0; j < M/cm ; j++) {
                if ( (N*j+y-x)%M == 0){
                    ans = N*j+y;
                    break;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();

    }
}

