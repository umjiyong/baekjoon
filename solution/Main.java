import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        int t=N;
        int answer=0;
        do{
            answer++;

            int temp = t/10+t%10;

            t=t%10*10+temp%10;
        }while (N!=t);



           System.out.println(answer);
    }
}