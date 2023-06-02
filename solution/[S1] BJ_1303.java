import java.util.*;

public class Main {
	static Character[][] arr;
	static boolean visit[][];
	static int N, M, sumW, sumB, count;
	static int[] moveX = { 0, 0, -1, 1 };
	static int[] moveY = { 1, -1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new Character[M][N];   
		visit = new boolean[M][N];   

		for (int i = 0; i < M; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					count = 1;     
					if (arr[i][j] == 'W') {
						dfs('W', i, j);
						
						sumW += Math.pow(count, 2);
					}
					else if (arr[i][j] == 'B') {
						dfs('B', i, j);

						sumB += Math.pow(count, 2);
					}
				}
			}
		}

		System.out.println(sumW + " " + sumB);

		sc.close();
	}

	static void dfs(char c, int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < moveX.length; i++) {   
			int posX = x + moveX[i];
			int posY = y + moveY[i];

			if(posX >= 0 && posX < M && posY >= 0 && posY < N
					&& !visit[posX][posY] && arr[posX][posY] == c) {
				count++;
				dfs(c, posX, posY);
			}
		}
	}

}
