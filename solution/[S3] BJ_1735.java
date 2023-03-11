import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int cB = B;
        int cD = D;
        while (cD!=cB) {

            if (cD > cB) {
                cD -= cB;
            }
            else {
                cB -= cD;
            }
        }

        int top = (A*D/cB)+(C*B/cD);
        int bot = B/cB*D;

        int cTop = top;
        int cBot = bot;
        while (cTop!=cBot) {

            if (cTop > cBot) {
                cTop -= cBot;
            }
            else {
                cBot -= cTop;
            }
        }


        System.out.print(top/cTop+" "+bot/cTop);
    }
}
