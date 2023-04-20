import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

    static int N,M;
    static int numarr [];
    static boolean visited [];

       static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numarr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i< N; i++ ){
            numarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numarr);


        for (int i = 0; i < N; i++) {
            make(i, 1, "");
        }

        bw.flush();
    }
    static void make(int num, int len, String str) throws IOException {

        str = str + numarr[num] + " ";
        visited[num] = true;

        if (len == M) {
            bw.write(str);
            bw.newLine();
            visited[num] = false;
            return;
        }

        for (int i = 0; i < N; i++){
            if (!visited[i]) {
                make(i, len + 1, str);
            }
        }

        visited[num]=false;
    }

}

