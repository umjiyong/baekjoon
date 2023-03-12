import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int pre = Integer.parseInt(br.readLine());

        int [] gap = new int [N-1];

        for (int i = 0; i < N-1; i++){
            int temp = Integer.parseInt(br.readLine());
            gap [i] = temp - pre;
            pre = temp;
        }

        int div = gap[0];

        for (int i = 1; i < N-1; i++){
            int temp = gap[i];

            while (div != temp) {
                if (div > temp) {
                    div -= temp;
                }
                else {
                    temp -= div;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N-1; i++){
            answer += gap[i]/div-1;
        }

        System.out.println(answer);
    }
}