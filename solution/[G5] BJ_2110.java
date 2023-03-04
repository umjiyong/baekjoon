import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        ArrayList<Integer> pos = new ArrayList<>();



        for (int i = 0; i < N; i++) {
            pos.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(pos);

        int width = N/C+1;
        int prewidth = N/C;

        int gong = 1;
        boolean getm = false;
        int max = -1;

        while (true) {

            if(width==prewidth) break;
            gong = 1;
            int now=0;
            int next=1;


            while (next < N) {
                if (pos.get(next)-pos.get(now)<width) { // 목표 넓이 도달 실패
                    next++;
                }
                else { now = next; gong++; next++;} // 목표 넓이 도달 성공
            }
//	  System.out.println("설정너비"+width);
//	  System.out.println("공유기 갯수" + gong);

            if (gong<C) {
                if (!getm) {
                    getm = true;
                    max = prewidth*2;
                    width = (prewidth+width)/2;
                }
                else{
                    width = (prewidth+width)/2;
                }
            }

            else {
                prewidth = width;
                if (getm){
                    width=(prewidth+max)/2;
                }
                else {
                    width*=2;
                }
            }
        }
        System.out.println(width);
    }
}
