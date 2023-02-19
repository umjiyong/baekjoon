import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int M,N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            N = Integer.parseInt(br.readLine());

            Map <String,Integer> item = new HashMap<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String category = st.nextToken();

                if(item.get(category)==null) {
                    item.put(category,1);
                }
                else {
                    item.replace(category, item.get(category)+1);
                }
            }

            int answer = 1;

            for (int v : item.values()) {
                answer *= v+1;

            }

            bw.write((answer-1)+"\n");
        }

        bw.flush();
    }
}
