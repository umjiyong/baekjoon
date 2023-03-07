import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 1; i < N+1; i++){
            if (N%i == 0) {
                cnt ++;
            }
            if (cnt==K){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }
}
