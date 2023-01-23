import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

          int A,B,C;
          A=Integer.parseInt(st.nextToken());
          B=Integer.parseInt(st.nextToken());
          C=Integer.parseInt(st.nextToken());

          long answer = 0;

          if (B>=C) {
              System.out.println(-1);
              return;
          }

          while (((long)A + (long)(B * answer)) >= (long)(C*answer)) {
              answer++;
          }

          System.out.println(answer);

    }
}