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

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
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


        bw.write(max+"\n");

        StringBuilder sb = new StringBuilder();
        int index = N-1;

        int [] ans = new int [max];
        while(max > 0){
            if(lis[index]==max){
                ans[--max] = num[index];
            }
            index--;
        }

        for (int i : ans){
            bw.write(i+" ");
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
}