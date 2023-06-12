import java.util.*;

public class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt(), s = sc.nextInt(), m = sc.nextInt();
		
		int year = 0;
		while(true) {
			year++;
			if((year-e)%15 == 0 && (year-s)%28 == 0 && (year-m)%19 == 0) break;
		}
		System.out.print(year);
	}
}
