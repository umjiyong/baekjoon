import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();

        System.out.println(s.charAt(Integer.parseInt(br.readLine())-1));
    }
}
