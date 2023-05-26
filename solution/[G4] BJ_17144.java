import java.io.*;
import java.util.*;

public class Main {
	private static final int[] dr = { -1, 0, 1, 0 }; 
	private static final int[] dc = { 0, 1, 0, -1 };

	private static final int[][][] move = { 
			{ { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } },
			{ { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } } }; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); 

		int[][] map = new int[R][C]; 
		int[] airCleaner = new int[2]; 
		int airCleaner_idx = 0;
		int dustSum = 0;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == -1) { 
					airCleaner[airCleaner_idx++] = r;
				} else if (map[r][c] != 0) { 
					dustSum += map[r][c]; 
				}
			}
		}

		int[][] map_temp; 
		
		for (int t = 1; t <= T; t++) { 
			map_temp = new int[R][C]; 
			map_temp[airCleaner[0]][0] = -1; 
			map_temp[airCleaner[1]][0] = -1; 
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] > 0) { 
						int spread_cnt = 0; 
						int spread_mass = 0; 
                            
						for (int i = 0; i < dr.length; i++) {
							int nR = r + dr[i];
							int nC = c + dc[i];

							if (nR < 0 || nC < 0 || nR >= R || nC >= C) { 
								continue;
							}
							
							if (map[nR][nC] == -1) { 
								continue;
							}
							
							spread_cnt++;
							spread_mass = map[r][c] / 5; 
							dustSum += spread_mass; 
							map_temp[nR][nC] += spread_mass; 
						}
				
						map_temp[r][c] += (map[r][c] - (spread_cnt * spread_mass));
						dustSum -= (spread_cnt * spread_mass);
					}
				}
			} 
			for (int i = 0; i < R; i++) {
				map[i] = Arrays.copyOf(map_temp[i], C);
			}

			for (int i = 0; i < 2; i++) { 
				int cR = airCleaner[i]; 
				int cC = 0;
				
				for (int j = 0; j < 4; j++) { 
					while (true) {
						int nR = cR + move[i][j][0]; 
						int nC = cC + move[i][j][1];

						if (nR < 0 || nC < 0 || nR >= R || nC >= C) {
							break;
						}

						if (map[nR][nC] == -1) { 
							dustSum -= map_temp[cR][cC];
							break;
						}

						if (map[cR][cC] == -1) { 
							map[nR][nC] = 0;
						} else {
							map[nR][nC] = map_temp[cR][cC]; 
						}
					
						cR = nR; 
						cC = nC;
					}
				}
			} 
		} 
		System.out.println(dustSum);
	}
}
