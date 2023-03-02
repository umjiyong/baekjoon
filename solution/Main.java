import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static int W,V;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        String [] str = new String[5];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            str [i] = br.readLine();
            if (str[i].length() > max) {
                max = str[i].length();
            }
        }

        for (int i = 0; i < max; i++){
            for (int j = 0; j < 5; j++){
                if (str[j].length() <= i){
                    continue;
                }
                bw.write(str[j].charAt(i));
            }
        }

        bw.flush();

    }
}