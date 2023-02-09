import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [] x = new int [3];
        int [] y = new int [3];
        boolean [] check = new boolean [4];

        for (int i = 0 ; i < 3 ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());;
        }

        if (x[0]==x[1]) {
            sb.append(x[2]+" ");
        }
        else {
            if (x[0]==x[2])
                sb.append(x[1]+" ");
            else {
                sb.append(x[0]+" ");
            }
        }

        if (y[0]==y[1]) {
            sb.append(y[2]);
        }
        else {
            if (y[0]==y[2])
                sb.append(y[1]);
            else {
                sb.append(y[0]);
            }
        }

        System.out.println(sb.toString());
    }
}