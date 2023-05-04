import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Gem> gems = new PriorityQueue<>();

        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            gems.add(new Gem(m,v));
        }

        double ans = 0;
        ArrayList<Integer> bag = new ArrayList<>();

        for (int i = 0; i < K; i++){
            bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bag);

        PriorityQueue<Integer> valueQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < bag.size(); i++) {
            int weight = bag.get(i);

            while (!gems.isEmpty()) {

                if(gems.peek().price <= weight) {
                    valueQ.add(gems.poll().value); //가치만 넣는다.
                }else {
                    break;
                }
            }

            if(valueQ.isEmpty()) continue;
            ans += valueQ.poll();


        }


        System.out.printf("%.0f",ans);

    }
    static class Gem implements Comparable<Gem>{
        int price;
        int value;

        public Gem(int price, int value){
            this.price = price;
            this.value = value;
        }

        @Override
        public int compareTo(Gem g){
              if (this.price == g.price){
                return g.value-this.value;
            }
              else {
                  return  this.price-g.price;
              }
        }
    }
}
