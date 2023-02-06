import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (set.contains(temp)) sb.append(1+" ");
            else sb.append(0+" ");
        }
        sb.trimToSize();

       System.out.println(sb.toString());

    }
}