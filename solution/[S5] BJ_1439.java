import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str [] = br.readLine().split("");
		
		int a = 0;
		int b = 0;
		
		
		String flag = str[0];
		
		if(flag.contains("1")){
			a++;
        }
		else{
            b++;
        }
			
		
		for(int i = 0; i < str.length;i++) {
			
			if(flag.contains(str[i])) {
				continue;
			}
			
            else {
				flag = str[i];
				if(flag.contains("1"))
					a++;
				else
					b++;
			}
		}
		
		System.out.println(Math.min(a, b));
		
	}
}
