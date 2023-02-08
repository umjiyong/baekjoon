import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
           set.add(st.nextToken());
        }

        int answer = N;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            if (set.contains(st.nextToken())) answer--;
            else answer++;
        }


       System.out.println(answer);

    }
}
