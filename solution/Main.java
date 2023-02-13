import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startx= Integer.parseInt(st.nextToken());
            int starty= Integer.parseInt(st.nextToken());
            int endx= Integer.parseInt(st.nextToken());
            int endy= Integer.parseInt(st.nextToken());

            int answer = 0;
            N = Integer.parseInt(br.readLine());

            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if(Math.pow(x-startx,2)+Math.pow(y-starty,2)<Math.pow(r,2)^Math.pow(x-endx,2)+Math.pow(y-endy,2)<Math.pow(r,2)) answer ++;
            }
            System.out.println(answer);
        }
    }
}