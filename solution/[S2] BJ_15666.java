import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int card[];
    static int store[];
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        card = new int[n];
        for(int i = 0; i < n; i++)
        {
            card[i] = scan.nextInt();
        }
        Arrays.sort(card);

        store = new int[m];

        dfs(0);
        System.out.print(sb);

    }
    
     public static void dfs(int stage)
    {
        if(stage == m)
        {
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < m; i++)
            {
                sb2.append(store[i] + " ");
            }

            if(!set.contains(sb2.toString()))
            {
                sb.append(sb2+"\n");
                set.add(sb2.toString());
            }

            return;

        }

        for(int i = 0; i < n; i++)
        {
            if(stage > 0 && store[stage-1] > card[i]) continue;
            store[stage] = card[i];
            dfs15666(stage+1);
        }

    }
}
