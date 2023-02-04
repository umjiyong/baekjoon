import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
        String num = sc.next();

        int [] answer = new int [num.length()];

        for (int i = 0; i<num.length(); i++){
            answer[i] = num.charAt(i)-48;
        }

        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i = num.length()-1; i>-1; i--){
            sb.append(answer[i]);
        }

       System.out.println(sb.toString());

    }
}
