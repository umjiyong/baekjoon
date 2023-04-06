import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<abs> pq = new PriorityQueue<abs>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0){
                if (pq.size()==0){
                    bw.write(0+"\n");
                }
                else {
                    bw.write(Integer.valueOf(pq.poll().origin) + "\n");
                }
            }
            else {
                pq.add(new abs(temp));
            }
        }

        bw.flush();

    }

    static class abs implements Comparable<abs>{
        int origin;
        int absValue;

        public abs (int a){
            this.origin = a;
            this.absValue = Math.abs(a);
        }

        @Override
        public int compareTo(abs o) {
            if (this.absValue==o.absValue){
                return this.origin-o.origin;
            }
            return this.absValue-o.absValue;
        }
    }
}

