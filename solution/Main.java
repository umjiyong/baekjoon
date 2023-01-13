import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            bw.write("Case #"+(i+1)+": "+Integer.toString(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }





        bw.flush();
    }
}