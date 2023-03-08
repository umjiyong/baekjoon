import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true){
            int N = Integer.parseInt(br.readLine());

            if (N == -1) {
                bw.flush();
                return;
            }


            StringBuilder sb = new StringBuilder();
            sb.append(N+" = ");
            int total = 0;


            for (int i = 1; i <= N/2; i++) {
                if (N%i == 0) {
                    total += i;
                    sb.append(i);
                    if (total < N) {
                        sb.append(" + ");
                    }
                    else if (total > N) {
                        bw.write(N+" is NOT perfect."+"\n");
                        break;
                    }
                }
            }

            if (total < N) {
                bw.write(N+" is NOT perfect."+"\n");
            }
            else if (total == N){
                bw.write(sb.toString()+"\n");
            }
        }

    }
}
