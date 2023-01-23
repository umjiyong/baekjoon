import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

          int answer = N;
          for (int i=0; i < N; i++) {
              String code = br.readLine();
              boolean [] check = new boolean [26];

              for (int j=0; j< code.length(); j++) {
                  int index = code.charAt(j)-'a';


                  if (check [index]) {answer --;
                      break;}

                  else {
                      check[index] = true;
                      while (j < code.length() - 1 && code.charAt(j+1)-'a'==index){
                          j++;
                      }
                  }
              }
          }

          System.out.println(answer);

    }
}
