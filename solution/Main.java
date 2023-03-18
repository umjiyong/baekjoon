import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;
    static boolean get = false;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [] A = new int [N];

        int point = 0;

//        for (String temp : br.readLine().split(" ")) {
//            A[point] = Integer.parseInt(temp);
//            point++;
//        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(A,0,N-1);

        if (!get) {
            System.out.println(-1);
        }
    }

    private static void merge_sort(int[] a,int start, int end) {

        if (start==end) return;

        int middle = (start+end)/2;

        merge_sort(a,start,middle);
        merge_sort(a,middle+1,end);

        merging(a,start,middle,end);
    }

    private static void merging(int[] a, int start, int middle, int end) {
        int [] temp = new int [end - start + 1];

        int pointer = 0;
        for (int i = start; i <= middle; i++){
            temp[pointer] = a[i];
            pointer ++;
        }
        for (int i = middle+1; i <= end; i++){
            temp[pointer] = a[i];
            pointer ++;
        }
        Arrays.sort(temp);

        count += end - start + 1 ;
        if (count >= K && !get) {
            System.out.println(temp[end-start-(count-K)]);
            get = true;
        }
    }
}