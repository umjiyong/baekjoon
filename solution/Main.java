import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int [] doll;
    static int L;
    static int R;
    static int answer = Integer.MAX_VALUE;

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

        int tc = 0;
        for (int i = 0; i<N; i++){
            if (doll[i]==1) tc++;
        }
        if (tc<K) {
            System.out.println(-1);
            return;
        }

        L=0;
        R=0;
        int count = 0;
        if (doll[0]==1) count ++;
        while(R<N){
            if (count < K) {
                R++;
                if (R==N) {
                    break;
                }
                if(doll[R]==1){
                    count++;
                }
            }
            else {
                answer = Math.min (R-L+1,answer);
                L++;
                if (doll[L-1]==1) {
                    count--;
                }
            }
        }

        System.out.println(answer);
    }

}