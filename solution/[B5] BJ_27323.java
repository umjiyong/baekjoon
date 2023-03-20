import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a,b;

        a=Integer.parseInt(br.readLine());
        b=Integer.parseInt(br.readLine());

        bw.write(String.valueOf(a*b));


        bw.flush();


    }
}
