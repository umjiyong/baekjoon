import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int xmin = 10001;
        int xmax = -10001;
        int ymin = 10001;
        int ymax = -10001;

        for (int i = 0 ; i < N; i ++){
            st=new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xmin = Math.min(x,xmin);
            xmax = Math.max(x,xmax);
            ymin = Math.min(y,ymin);
            ymax = Math.max(y,ymax);

        }

        System.out.println((xmax-xmin)*(ymax-ymin));
    }
}
