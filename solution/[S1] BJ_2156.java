import java.util.*;
 
public class Main {
 
    static int count;
    static int[] drink;
    static int[] dp;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        drink = new int[count + 1];
        dp = new int[count + 1];
 
        for (int i = 1; i < count + 1; i++) {
            drink[i] = sc.nextInt();
        }
        dp[1] = drink[1];
 
        if (count >= 2)
            dp[2] = drink[2] + dp[1];
        
        for (int i = 3; i < count + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + drink[i - 1] + drink[i], dp[i - 2] + drink[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[count]);
    }
 
}
