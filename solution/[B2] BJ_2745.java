import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int len = N.length();

        int ans = 0;

        for (int i = 0; i < len; i++){
            char temp = N.charAt(i);
            int intv;

            if (temp <65){
                intv = temp -48;
            }
            else {
                intv = temp -55;
            }
            for (int j = i; j < len-1; j++){
                intv *= B;
            }
            ans += intv;
        }
        System.out.println(ans);

        bw.flush();

    }
}

