import java.io.*;
import java.util.*;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Queue<count> pq = new LinkedList<>();

        boolean[] visit = new boolean[N + 1];
        visit[N] = true;

        pq.add(new count(N,new ArrayList<>()));

        while (!pq.isEmpty()){
            count temp = pq.poll();

            if (temp.value == 1){
                System.out.println(temp.ans.size()-1);
                for (int a : temp.ans){
                    System.out.print(a+" ");
                }
                return;
            }

            if (temp.value % 3 == 0 && !visit[temp.value/3]){
                visit[temp.value/3]=true;
                pq.add(new count(temp.value/3,temp.ans));
            }
            if (temp.value % 2 == 0 && !visit[temp.value/2]){
                visit[temp.value/2] = true;
                pq.add(new count(temp.value/2,temp.ans));
            }
            if (!visit[temp.value-1]){
                visit[temp.value-1] = true;
                pq.add(new count(temp.value-1,temp.ans));
            }

        }


    }

    static class count{
        int value;
        ArrayList<Integer> ans;

        public count (int value, ArrayList ans){
            this.value = value;
            this.ans = new ArrayList<>(ans);
            this.ans.add(value);
        }
    }
}
