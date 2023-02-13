import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());


            if (x1==x2&&y1==y2&&r1==r2){ // 겹침
                System.out.println(-1);
                continue;
            }


            double DisPow = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            if (DisPow >Math.pow(r1+r2,2) || Math.sqrt(DisPow)+r1 < r2 || Math.sqrt(DisPow) + r2 < r1){
                System.out.println(0);
                continue;
            }
            if (DisPow == Math.pow(r1+r2,2)|| Math.sqrt(DisPow)+r1 == r2 || Math.sqrt(DisPow) + r2 == r1){
                System.out.println(1);
                continue;
            }
            System.out.println(2);
        }
    }
}