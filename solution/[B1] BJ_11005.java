import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (!(N < B)){
            int now = N%B;

            if (now < 10){
                sb.append (String.valueOf(now));
            }
            else {
                sb.append ((char)(55+now));
            }

            N/=B;
        }
        if (N < 10){
            sb.append (String.valueOf(N));
        }
        else {
            sb.append((char)(55+N));
        }
        bw.write(sb.reverse().toString());
        bw.flush();
    }
}

