import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        int N = len/2 + len%2;



        for (int i = 0; i < N; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);



    }
}
