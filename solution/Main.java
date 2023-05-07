import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int [][] sumMin = new int [N][3];
        int [][] sumMax = new int [N][3];

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sumMin[0][0] = a;
        sumMax[0][0] = a;
        sumMin[0][1] = b;
        sumMax[0][1] = b;
        sumMin[0][2] = c;
        sumMax[0][2] = c;


        for (int i = 1 ; i < N; i++){

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            sumMin[i][0] = a + Math.min(sumMin[i-1][0],sumMin[i-1][1]);
            sumMin[i][1] = b + Math.min(Math.min(sumMin[i-1][0],sumMin[i-1][1]),sumMin[i-1][2]);
            sumMin[i][2] = c + Math.min(sumMin[i-1][1],sumMin[i-1][2]);

            sumMax[i][0] = a + Math.max(sumMax[i-1][0],sumMax[i-1][1]);
            sumMax[i][1] = b + Math.max(Math.max(sumMax[i-1][0],sumMax[i-1][1]),sumMax[i-1][2]);
            sumMax[i][2] = c + Math.max(sumMax[i-1][1],sumMax[i-1][2]);
        }

        int max = Math.max(sumMax[N-1][0],Math.max(sumMax[N-1][1],sumMax[N-1][2]));
        int min = Math.min(sumMin[N-1][0],Math.min(sumMin[N-1][1],sumMin[N-1][2]));

        bw.write(max+" "+min);
        bw.flush();

    }
}