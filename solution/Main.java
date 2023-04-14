import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int [] doll;
    static int L;
    static int R;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        doll = new int [N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            doll[i] = Integer.parseInt(st.nextToken());
        }

        L = K;
        R = N;

        int tc = 0;
        for (int i = 0; i<N; i++){
            if (doll[i]==1) tc++;
        }
        if (tc<K) {
            System.out.println(-1);
            return;
        }

        answer = Integer.MAX_VALUE;
        slide();

        System.out.println(answer);
    }

    private static void slide() {

        int size;

        while (L <= R) {
            size = (L+R)/2;

            int cnt[] = new int[3];

            for (int i = 0; i < size - 1; i++){
                cnt[doll[i]]++;
            }

            boolean check = false;

            for (int i = size-1; i < N; i++) {
                cnt[doll[i]]++;

                if (cnt[1]>=K){
                    R = size-1;
                    answer = Math.min(answer,size);
                    check = true;
                    break;
                }

                cnt[doll[i+1-size]]--;
            }

            if (!check){
                L = size+1;
            }
        }
    }

}