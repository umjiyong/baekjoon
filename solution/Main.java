import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;

//        int N = Integer.parseInt(br.readLine());

          String code = br. readLine();

          N = code.length();

          int answer = 0;
          for (int i=0; i < N; i++) {

              char temp = code.charAt(i);
              int tempnum = temp-65;

              if (tempnum <= 14){
                  answer += tempnum/3+3;
              }

              else if (tempnum <= 18) {
                 answer += 8;
              }

              else if (tempnum <= 21){
                  answer += 9;
              }
              else {
                  answer += 10;
              }

          }

          System.out.println(answer);


    }
}