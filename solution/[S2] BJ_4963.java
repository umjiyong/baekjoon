import java.io.*;
import java.util.*;

public class Main {

  static int w, h, count; 
  static int[][] map;
  static boolean[][] checked; //확인
  static int[] dx = {1, 0, -1, 0, -1, -1, 1, 1}; 
  static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    w = sc.nextInt();
    h = sc.nextInt();

    while (w != 0 && h != 0) {
      map = new int[h][w]; 
      checked = new boolean[h][w]; 
      count = 0; 

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          map[i][j] = sc.nextInt();
        }
      }

      for (int a = 0; a < h; a++) {
        for (int b = 0; b < w; b++) {
          if (map[a][b] == 1 && checked[a][b] == false) {
            dfs(a, b);
            count++;
          }
        }
      }
      System.out.println(count);

      w = sc.nextInt();
      h = sc.nextInt();
    }
  }

  public static void dfs(int x, int y) {
    checked[x][y] = true;

    for (int t = 0; t < 8; t++) {
      int temp_x = x + dx[t];
      int temp_y = y + dy[t];

      if (temp_x >= 0 && temp_x < h && temp_y >= 0 && temp_y < w) {
        if (map[temp_x][temp_y] == 1 && checked[temp_x][temp_y] == false) {
          dfs(temp_x, temp_y);
        }
      }
    }
  }
}
