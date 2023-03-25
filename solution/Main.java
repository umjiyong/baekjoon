import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = -1001;

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());

            sum += temp;

            max = Math.max(max,sum);

            if (sum < 0) sum = 0;
        }
        System.out.println(max);

    }
}