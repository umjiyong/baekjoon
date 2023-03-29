import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Status> q = new LinkedList<>();

        q.add(new Status(1,0));

        while (!q.isEmpty()){
            Status temp = q.poll();

            int temp_p = temp.point;
            int temp_c = temp.count;

            if (temp_p > 100 || visited[temp_p]) {
                continue;
            }
            if (temp_p == 100) {
                System.out.println(temp_c);
                return;
            }
            visited[temp_p] = true;

            for (int i = 1; i < 7; i++) {

                if (ladder.containsKey(temp_p+i)){
                    q.add(new Status(ladder.get(temp_p+i),temp_c+1));
                    continue;
                }
                if (snake.containsKey(temp_p+i)) {
                    q.add(new Status(snake.get(temp_p+i),temp_c+1));
                    continue;
                }

                q.add(new Status(temp_p+i,temp_c+1));
            }
        }
    }



}

class Status implements Comparable<Status>{
    int point;
    int count;

    public Status(int point, int count) {
        this.point = point;
        this.count = count;
    }

    @Override
    public int compareTo(Status o) {
        return this.count-o.count;
    }
}

