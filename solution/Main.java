import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float total = 0;
        float taken = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            float tempTaken = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();

            switch (grade) {
                case "A+" :
                    total += tempTaken*4.5;
                    taken += tempTaken;
                    break;
                case "A0" :
                    total += tempTaken*4.0;
                    taken += tempTaken;
                    break;
                case "B+" :
                    total += tempTaken*3.5;
                    taken += tempTaken;
                    break;
                case "B0" :
                    total += tempTaken*3.0;
                    taken += tempTaken;
                    break;
                case "C+" :
                    total += tempTaken*2.5;
                    taken += tempTaken;
                    break;
                case "C0" :
                    total += tempTaken*2.0;
                    taken += tempTaken;
                    break;
                case "D+" :
                    total += tempTaken*1.5;
                    taken += tempTaken;
                    break;

                case "D0" :
                    total += tempTaken*1.0;
                    taken += tempTaken;
                    break;
                case "F" :
                    taken += tempTaken;
                    break;

                default: break;

            }
        }
        System.out.printf("%.6f",total/taken);


    }
}
