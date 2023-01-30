
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        int max = -1;
        int answeri=-1, answerj=-1;

        for (int i = 1; i<10; i++){
            for (int j = 1; j<10; j++) {
                int temp = sc.nextInt();
                if (temp > max) {
                    max = temp;
                    answeri = i;
                    answerj = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(answeri+" "+answerj);




    }
}