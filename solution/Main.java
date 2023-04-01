import java.io.*;
import java.util.*;

public class Main {

    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       K = Integer.parseInt(st.nextToken());

       ArrayList<Integer> coins = new ArrayList<>();

       for (int i = 0; i < N; i++){
           coins.add(Integer.parseInt(br.readLine()));
       }

       int sum = 0;
       int answer = 0;

       for (int i = 0; sum != K; ){
           answer += 1;
           sum += coins.get(N-1-i);

           if (sum > K) {
               answer -= 1;
               sum -= coins.get(N-1-i);
               i++;
           }
       }
       bw.write(String.valueOf(answer));
       bw.flush();
    }
}

