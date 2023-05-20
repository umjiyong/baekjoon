import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] squareMatrix;
    static int N;
    static long B;
    static final int mod = 1000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        squareMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                squareMatrix[i][j] = temp;
            }
        }

        int[][] result = recur(B); // getMultipliedMatrix(squareMatrix, squareMatrix);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % mod).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] recur(long n) {
        if (n == 1) {
            return squareMatrix;
        }
        int[][] temp = recur(n / 2);
        if (n % 2 == 1) {
            return getMultipliedMatrix(getMultipliedMatrix(temp, temp), squareMatrix);
        }
        return getMultipliedMatrix(temp, temp);
    }

    private static int[][] getMultipliedMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tempElement = 0;
                for (int k = 0; k < N; k++) {
                    tempElement += matrix1[i][k] * matrix2[k][j] % mod;
                }
                resultMatrix[i][j] = tempElement % mod;
            }
        }
        return resultMatrix;
    }
}
