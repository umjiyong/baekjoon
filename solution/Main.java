import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            int len = temp.length();
            int hlen = len/2+1;
            boolean check = false;

            for (int j = 0; j < hlen; j++){
                if (temp.charAt(j)==temp.charAt(len-1-j)) continue;
                else {
                    bw.write(0+" "+(j+1)+"\n");
                    check = true;
                    break;
                }
            }
            if (check) continue;
            bw.write(1+" "+hlen+"\n");
        }
        bw.flush();

    }
}