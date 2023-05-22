import java.io.*;
import java.util.*;

public class Main {
 
   private static int n, k;
   private static int[] map;
   private static int[] count;
   
   private static int[] dx = {-1, 1, 2};
   
   public static void main(String[] args) throws IOException {
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(reader.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      map = new int[100001];
      count = new int[100001];
      
      bfs();
      
      System.out.println(map[k]-1);
      System.out.println(count[k]);
   }

   private static void bfs() {
      
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(n);
      
      count[n] = 1;
      map[n] = 1;

      while (!q.isEmpty()) {
         
         int num = q.remove();
         
         int nx = 0;
         for (int i=0; i<dx.length; i++) {

            if (i == 2) {
               nx = num * dx[i];
            } else {
               nx = num + dx[i];
            }
            
            
            if (nx >= 0 && nx < 100001) {

               
               if (map[nx] == map[num] + 1) {

                  count[nx] += count[num]; 
               } else {
                  if (map[nx] == 0 || map[nx] > map[num] + 1) {
        
                     map[nx] = map[num] + 1; 
                  
                     count[nx] = count[num];
                     
                     q.add(nx);
                  }
               }
               
            }
            
         }
      }
      
   }
}
