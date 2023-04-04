import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Map<String,Integer> anslist = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String key = st.nextToken();

            if (!anslist.containsKey(key)){
                anslist.put(key,1);
            }
            else {
                anslist.remove(key);
            }
        }

        ArrayList<String> keylist = new ArrayList<String>(anslist.keySet());
        Collections.sort(keylist,Collections.reverseOrder());

        for (String s : keylist){
            bw.write(s+"\n");
        }
        bw.flush();
    }
}

