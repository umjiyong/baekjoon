import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static int W,V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [][] backpack = new int [N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            for (int j = 0; j < W; j++){ // 가방에 들어 갈 수 없는 물건 (물건 하나의 무게가 제한 사항 보다 높기 때문에)
                if (j > K) { // INDEX
                    break;
                }
                    backpack[i][j] = backpack[i-1][j];
            }

            for (int j = W; j < K+1; j++){ // 현재 물건을 넣기 전과 비교
                backpack [i][j] = Math.max(backpack[i-1][j-W]+V,backpack[i-1][j]);
            }
        }

        bw.write(Integer.toString(backpack[N][K]));

        bw.flush();
    }
}
