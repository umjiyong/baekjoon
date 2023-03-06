import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue <Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue <Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            int abs = Math.abs(temp);

            if (temp > 0) {
                plus.add(abs);
            }
            else {
                minus.add(abs);
            }
        }

        int peek = 0;

        if (!plus.isEmpty()) {
            peek = Math.max(peek,plus.peek());
        }
        if (!minus.isEmpty()) {
            peek = Math.max(peek,minus.peek());
        }

        int total = 0;

        int cnt = 0;
        while (!plus.isEmpty()){
            int temp = plus.poll();
            if (cnt%M==0) {
                total += temp;
            }
            cnt ++;
        }
        cnt = 0;
        while (!minus.isEmpty()){
            int temp = minus.poll();
            if (cnt%M==0) {
                total += temp;
            }
            cnt ++;
        }

        System.out.println(total*2 - peek);

    }
}
