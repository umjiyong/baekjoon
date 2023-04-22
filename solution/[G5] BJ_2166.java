import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Double x [] = new Double [N+1];
        Double y [] = new Double [N+1];
        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            x[i]= Double.parseDouble(st.nextToken());
            y[i]= Double.parseDouble(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];

        Double total = 0.0;
        for(int i = 0; i < N; i++){
            total += x[i]*y[i+1];
            total -= x[i+1]*y[i];
        }

        total = Math.abs(total);
        total/=2;

        System.out.printf("%.1f",total);
    }
}
