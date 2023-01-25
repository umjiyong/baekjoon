import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());


          N=Integer.parseInt(br.readLine());

          int t = 0;

          while (true) {
              t++;
              if ( t*(t+1)/2>=N) break;
          }

          int gap = N - ((t-1)*t/2);


          if(t%2==1){
              System.out.println((t-(gap)+1)+"/"+gap);

          }
          else {
              System.out.println(gap+"/"+(t-(gap)+1));
          }


    }
}