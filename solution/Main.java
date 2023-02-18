import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N-1; i++) {

            int temp = Integer.parseInt(st.nextToken());

            int d = getd(origin,temp);

            bw.write(origin/d+"/"+temp/d+"\n");
        }

        bw.flush();
    }

    static int getd (int x, int y){
        while (x!=y) {
            if (x>y) x -=y;
            else y-= x;
        }
        return x;
    }
}