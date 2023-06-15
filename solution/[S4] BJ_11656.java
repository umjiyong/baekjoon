import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] s = br.readLine().split("");
    String[] answer = new String[s.length];

    for(int i = 0; i < s.length; i++) {
      StringBuilder sb = new StringBuilder();
      for(int j = i; j < s.length; j++) {
        sb.append(s[j]);
      }
      answer[i] = sb.toString();
    }

    Arrays.sort(answer);

    for(String str : answer) {
      bw.write(str + "\n");
    }
    bw.flush();
  }
}
