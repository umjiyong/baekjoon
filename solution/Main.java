import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Planet> planets = new ArrayList<>();
    static List<Planet> planetsX, planetsY, planetsZ;
    static boolean [] visited;
    static int[] parents;

    static List<Node> connect = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parents = new int [N+1];
        for (int i=1; i <= N; i++) { // 부모를 자기 정보로 채워넣기
            parents[i] = i;
        }


        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets.add(new Planet(i,x,y,z));
        }

        planetsX = new ArrayList<>(planets);
        planetsX.sort((o1, o2) -> o1.x - o2.x);
        planetsY = new ArrayList<>(planets);
        planetsY.sort((o1, o2) -> o1.y - o2.y);
        planetsZ = new ArrayList<>(planets);
        planetsZ.sort((o1, o2) -> o1.z - o2.z);

        double ans = 0;

        for (int i = 0; i < N-1; i++){
            for (List<Planet> lp : new List[] {planetsX,planetsY,planetsZ}){
                getConnect(i, lp);
            }
        }

        Collections.sort(connect);

        int count = 0;
        int cIndex = 0;

        while (count < N-1){
            Node now = connect.get(cIndex);
            cIndex++;
            if (isSameParent(find(now.to),find(now.from))){
                continue;
            }
            union(now.to,now.from);
            ans += now.value;
            count ++;
        }

        System.out.printf("%.0f",ans);

    }

    private static void getConnect(int i, List<Planet> lp) {
        Planet planet1 = lp.get(i);
        Planet planet2 = lp.get(i+1);

        if(lp==planetsX){
            connect.add(new Node(planet1.key,planet2.key,Math.abs(planet1.x-planet2.x)));
        }else if(lp==planetsY){
            connect.add(new Node(planet1.key,planet2.key,Math.abs(planet1.y-planet2.y)));
        }else if(lp==planetsZ){
            connect.add(new Node(planet1.key,planet2.key,Math.abs(planet1.z-planet2.z)));
        }
    }

    static class Planet{
        int key;
        int x;
        int y;
        int z;

        public Planet (int key, int x, int y, int z){
            this.key = key;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }

    static int find(int x){
        if (parents[x] == x){ // 자기 자신이 부모면 return
            return x;
        }
        else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union (int x, int y){
        x = find(x);
        y = find(y);

        if (x < y) { // 작은 쪽이 부모가 됨
            parents[y] = x;
        }
        else {
            parents[x] = y;
        }
    }

    static boolean isSameParent(int rx, int ry) {
        if(rx == ry) return true;
        return false;
    }


}