import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


//        N = Integer.parseInt(br.readLine());
        boolean [] arr =new boolean [31];

//        st = new StringTokenizer(br.readLine());

        for (int i=0; i<28; i++){
            arr[Integer.parseInt(br.readLine())]=true;
        }


        for (int i=1; i<31; i++){
            if(!arr[i]) System.out.println(i);
        }

    }
}
