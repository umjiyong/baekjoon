import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String [] com = new String[10000];
            boolean [] visited = new boolean[10000];

            Arrays.fill(com,"");

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start]=true;

            while (!visited[target]){
                int temp = q.poll();

                int Dnum = temp*2%10000;
                int Snum = temp-1;
                if (Snum==-1){
                    Snum = 9999;
                }
                int Lnum = (temp%1000)*10+temp/1000;
                int Rnum =  (temp%10)*1000+temp/10;

                ComNum [] DSLR = {new ComNum("D",Dnum),new ComNum("S",Snum),new ComNum("L",Lnum),new ComNum("R",Rnum)};

                for (ComNum next : DSLR){
                    int nextN = next.num;
                    if(!visited[nextN]){
                        q.add(nextN);
                        visited[nextN]=true;
                        com[nextN]= com[temp]+next.com;
                    }
                }
            }
            bw.write(com[target]+"\n");
        }
        bw.flush();

    }
    static class ComNum {
        String com;
        int num;
        public ComNum (String com, int num){
            this.com = com;
            this.num = num;
        }
    }
}

