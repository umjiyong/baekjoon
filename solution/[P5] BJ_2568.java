import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int [] num;
    static ArrayList <Integer> x = new ArrayList<>();

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x.add(Integer.MIN_VALUE);

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        ArrayList<line> connect = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            connect.add(new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(connect, Comparator.comparing(l->l.a));

        int connectIndex = 0;
        for (line c : connect){
            num[connectIndex++]=c.b;
        }


        int max = 0;

        int[] lis = new int[N];

        for(int i = 0; i < N; i++) {

            int size = x.size();

            int j = bs(0, x.size(), num[i]);

            if(j == size) {
                x.add(num[i]);
            }
            else {
                x.set(j, num[i]);
            }
            lis[i] = j;
            max = Math.max(j,  max);
        }


        bw.write(N-max+"\n");

        int index = N-1;

        ArrayList<Integer> used = new ArrayList<>();
        while(max > 0){
            if(lis[index]==max){
                used.add(index);
                max--;
            }
            index--;
        }
        for (int i = 0 ; i < N; i++){
            if (!used.contains(i)){
                bw.write(connect.get(i).a+"\n");
            }
        }
        bw.flush();
    }

    public static int bs(int start, int end, int value) {
        while(start < end) {
            int mid = (start + end)/2;
            int midValue = x.get(mid);

            if(midValue < value) {
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    static class line{
        int a;
        int b;

        public line (int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
