import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for(int m=0; m<n; m++) {
            int left = 0, right = m; 
            int sum = 0;

            for(int i=0; i<=right; i++) {
                sum += arr[i];
            }
            if(sum == target) result++;
            right++;

            while(right < n) {      
                sum -= arr[left++];
                sum += arr[right++];
                if(sum == target) result++;
            }
        }
        System.out.println(result);
    }
}
