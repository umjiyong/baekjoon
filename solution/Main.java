import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long [] tri = new long[100];

        tri[0] = 1;
        tri[1] = 1;
        tri[2] = 1;
        tri[3] = 2;
        tri[4] = 2;

        for (int i = 5; i < 100; i++){
            tri[i] = tri[i-1]+tri[i-5];
        }

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            System.out.println(tri[temp-1]);
        }



    }
}