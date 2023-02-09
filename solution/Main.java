import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Set<String> set = new HashSet<>();

        N = str.length();

        for (int i = 0; i < N; i++){
            for (int j=i+1; j < N+1; j++) {
                set.add(str.substring(i,j));
            }
        }

        System.out.println(set.size());
    }
}