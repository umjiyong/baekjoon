import java.io.*;
import java.util.*;

public class Main {

    static Map<String,String> memo= new HashMap<>();
    static int N,M;
    static PriorityQueue<Integer> ans_list = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       for (int i = 0; i < N; i++){
           st = new StringTokenizer(br.readLine());
           memo.put(st.nextToken(),st.nextToken());
       }

       for (int i = 0; i < M; i++){
           String temp = br.readLine();
           bw.write(memo.get(temp)+"\n");
       }

       bw.flush();
    }
}

