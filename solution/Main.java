import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(br.readLine());

        int [][] data = new int [6][2];
        int [] len = new int [5];

        for (int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dr = Integer.parseInt(st.nextToken());
            int tlen = Integer.parseInt(st.nextToken());

            data[i][0] = dr;
            data[i][1] = tlen;
            len[dr]=tlen;
        }

        int mxlen=0, mylen=0;
        int mxdr=0, mydr=0;

        if(data[5][0]==data[1][0]){
            if (data[0][0]==1 || data[0][0]==2) {
                mxdr=data[0][0];
                mxlen=data[0][1];
            }
            else {
                mydr=data[0][0];
                mylen=data[0][1];
            }
        }

        for (int i=1; i<5; i++){
            if (data[i-1][0]==data[i+1][0]) {
                if (data[i][0]==1 || data[i][0]==2) {
                    mxdr=data[i][0];
                    mxlen=data[i][1];
                }
                else {
                    mydr=data[i][0];
                    mylen=data[i][1];
                }
            }
        }

        if(data[4][0]==data[0][0]){
            if (data[5][0]==1 || data[5][0]==2) {
                mxdr=data[5][0];
                mxlen=data[5][1];
            }
            else {
                mydr=data[5][0];
                mylen=data[5][1];
            }
        }
        System.out.println((len[3-mxdr]*len[7-mydr]-mxlen*mylen)*N);
    }
}