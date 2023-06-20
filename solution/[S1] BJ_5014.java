import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] fsgud = br.readLine().split(" ");

        int f = Integer.parseInt(fsgud[0]); // 총 층수
        int s = Integer.parseInt(fsgud[1]); // 시작 층
        int g = Integer.parseInt(fsgud[2]); // 목표 층
        int u = Integer.parseInt(fsgud[3]); // 한 번에 올라갈 수 있는 수
        int d = Integer.parseInt(fsgud[4]); // 한 번에 내려갈 수 있는 수

        int[] upAndDown = {u, -1 * d};

        int[] visited = new int[f + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = 1;

        while(!queue.isEmpty()) {
            int front = queue.remove();

            for (int i = 0; i < 2; i++) {

                int next = front + upAndDown[i];

                if(0 < next && next <= f) {
                    if(visited[next] == 0) {
                        visited[next] = visited[front] + 1;
                        queue.add(next);
                    }
                }
            }
        }

        if (visited[g] != 0) {
            bw.write(String.valueOf(visited[g] - 1));
        }
        else if(s == g) {
            bw.write("0");
        } else {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
    }
}
