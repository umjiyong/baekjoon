import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        System.out.println(fac(N,1));
    }

    private static int fac(int n,int mul) {

        if (n==0) return mul;

        return (fac(n-1,mul*n));
    }
}