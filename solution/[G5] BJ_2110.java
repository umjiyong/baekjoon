import java.io.*;
import java.util.*;

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

        int width = N/C; // 설정 너비
        int prewidth = N/C-1;

        int gong; // 공유기 갯수
        boolean getm = false;
        int max = -1;

        while (width!=prewidth) {
            gong = 1;
            int now=0;
            int next=1;


            while (next < N) {
                if (pos.get(next)-pos.get(now)<width) { // 목표 넓이 도달 실패
                    next++;
                }
                else {
                    now = next;
                    gong++;
                    next++;} // 목표 넓이 도달 성공
            }

            if (gong<C) {
                    getm = true;
                    max = width;
                    width = (prewidth+width)/2;
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
