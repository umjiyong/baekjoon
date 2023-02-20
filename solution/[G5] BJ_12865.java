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
        N = Integer.parseInt(st.nextToken()); // 물건의 개수
        K = Integer.parseInt(st.nextToken()); // 가방의 제한 무게

        int [][] backpack = new int [N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken()); // 물건의 무게
            V = Integer.parseInt(st.nextToken()); // 물건의 가치

            for (int j = 0; j < W; j++){ // 가방에 물건이 들어갈 수 없는 경우 (물건 하나의 무게가 제한 사항 보다 높기 때문에)
                if (j > K){
                    break;
                }
                backpack[i][j] = backpack[i-1][j];
            }

            for (int j = W; j < K+1; j++){// 가방에 물건을 넣었을 때와 넣지 않았을 때를 비교하여 가치의 최댓값을 넣어줌
                backpack[i][j] = Math.max(backpack[i-1][j-W]+V,backpack[i-1][j]);
            }
        }
        bw.write(Integer.toString(backpack[N][K]));
        bw.flush();
    }
}
