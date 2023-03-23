import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] fib = new int [40];

        fib[0]=1;
        fib[1]=1;

        for (int i = 2; i < 40; i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }

        System.out.println(fib[N-1]+" "+(N-2));
    }
}
