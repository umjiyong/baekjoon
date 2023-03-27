import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int seq [] = new int [M];

            makeSeq(0,N,M,seq);

            bw.flush();
            return;

    }

    private static void makeSeq(int count,int n, int m,int [] sequence) throws IOException {

        if (count == m) return;
        int [] temp_seq = sequence.clone();

        for (int i = 1; i <= n; i++){
            boolean check = false;
            for (int j = 0; j < count; j++){
                if (temp_seq[j]==i) {
                    check = true;
                    continue;
                }
            }
            if (check) {
                continue;
            }
            temp_seq[count] = i;
            if (count==m-1) {
                for (int k = 0; k < m; k++){
                    bw.write(temp_seq[k]+" ");
                }
                bw.newLine();
            }
            else {
                makeSeq(count+1,n,m,temp_seq);
            }
        }


    }
}