import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());

        int answer [] = new int [5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            answer [i] = sc.nextInt();
            sum += answer[i];
        }

        Arrays.sort(answer);

       System.out.println(sum/5);
       System.out.println(answer[2]);

    }
}