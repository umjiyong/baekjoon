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

        N = sc.nextInt();
        int answer [] = new int [N];
        for (int i = 0; i < N; i++) {
            answer [i] = sc.nextInt();
        }

        Arrays.sort(answer);

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}