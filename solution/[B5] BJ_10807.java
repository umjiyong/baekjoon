import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        int [] arr =new int [N];
        int answer=0;
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int find = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            if(arr[i]==find) answer++;
        }


           System.out.println(answer);
    }
}
