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

              answer ++;
              char temp = code.charAt(i);

              if (temp == 'c' && i < N-1 && (code.charAt(i+1) == '='|code.charAt(i+1) == '-')) {
                 i++;
                 continue;
              }
              else if (temp == 'd' && i < N-1 && (code.charAt(i+1) == '-')){
                  i++;
                  continue;
              }
              else if (temp == 'd' && i < N-2 && (code.charAt(i+1) == 'z') && (code.charAt(i+2) == '=')){
                  i+=2;
                  continue;
              }
              else if (temp == 'l' && i < N-1 && (code.charAt(i+1) == 'j')){
                  i++;
                  continue;
              }
              else if (temp == 'n' && i < N-1 && (code.charAt(i+1) == 'j')){
                  i++;
                  continue;
              }
              else if (temp == 's' && i < N-1 && (code.charAt(i+1) == '=')){
                  i++;
                  continue;
              }
              else if (temp == 'z' && i < N-1 && (code.charAt(i+1) == '=')){
                  i++;
                  continue;
              }

          }

          System.out.println(answer);


    }
}