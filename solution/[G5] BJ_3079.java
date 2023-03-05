import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        int n= sc.nextInt();
        long m= sc.nextLong();

        long [] a = new long [n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);

        long start=0;
        long end = a[a.length-1] * m;
        long rlt= Long.MAX_VALUE;

        while (start<=end){

            long mid= (start+end)/2;
            long tmp = 0;

            for(int i=0;i<n;i++){
                tmp += (mid/a[i]);
                if (tmp >= m) break;
            }

            if (m<=tmp){ // 만족했을 때
                rlt = Math.min(rlt,mid);
                end = mid-1;
            }else{ // 불만족했을 때
                start = mid + 1;
            }

        }

        System.out.println(Long.valueOf(rlt));
    }
}
