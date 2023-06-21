import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static ArrayList<Point> glacier = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		map= new int[n][m];
		int index = 1;
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] != 0) {
					// 빙하일 때
					glacier.add(new Point(i, j, map[i][j]));
				} 
			}
		}
		System.out.println(solution());
	}

	private static int solution() {
		int year=0;
		while(true) {
			if(!check(glacier.get(0))) return year;
			year++;
			for(int i=0;i<glacier.size();i++) {
				Point p = glacier.get(i);
				int water = 0;
				for (int j = 0; j < 4;j++) {
					int x = p.x + move[j][0];
					int y = p.y + move[j][1];
					if (isIn(x, y) && !visited[x][y] && map[x][y] == 0) {
						water++;
					}
				}
				glacier.get(i).big=p.big-water<=0?0:p.big-water;
			}
			update();
			if(glacier.size()==0) break;
		}
		return 0;
	}

	private static boolean check(Point point) {
		// TODO Auto-generated method stub
		visited= new boolean[n][m];
		Queue <Point>q = new LinkedList<>();
		q.add(point);
		visited[point.x][point.y]=true;
		int cnt=1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0;i<4;i++) {
				int x = p.x + move[i][0];
				int y = p.y + move[i][1];
				if(isIn(x,y) && !visited[x][y] && map[x][y]!=0) {
					cnt++;
					q.add(new Point(x,y));
					visited[x][y]=true;
				}
			}
		}
		if(cnt==glacier.size()) return true;
		return false;
	}
	private static void update() {
		for(int i=0;i<glacier.size();i++) {
			Point p = glacier.get(i);
			map[p.x][p.y]=p.big;
			if(p.big==0) {
				glacier.remove(i);
				i--;
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<n && y<m;
	}

	private static class Point {
		int x, y;
		int big;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Point(int x, int y, int big) {
			this.x = x;
			this.y = y;
			this.big = big;
		}
	}
}
