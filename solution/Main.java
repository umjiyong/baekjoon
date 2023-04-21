import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        line [] lines = new line[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());

            lines[i] = new line(tempStart,tempEnd);
        }

        Arrays.sort(lines);

        int total = 0;
        int preEnd = Integer.MIN_VALUE;

        for (line tempLine : lines){

            if (tempLine.start <= preEnd && tempLine.end > preEnd){
                total += tempLine.end - preEnd;

            }
            else if (tempLine.end > preEnd){
                total += tempLine.end - tempLine.start;
            }

            preEnd = Math.max(preEnd,tempLine.end);
        }

        System.out.println(total);
    }

    static class line implements Comparable<line>{
        int start;
        int end;

        public line (int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(line o) {
            if (this.start==o.start){
                return this.end-o.end;
            }
            return this.start - o.start;
        }
    }
}
