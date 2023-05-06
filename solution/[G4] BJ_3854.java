import java.io.*;
import java.util.*;

public class Main {

    static int N,T;
    static int targetA, targetB;
    static ArrayList<Integer> parentList;
    static HashMap<Integer, Integer> nodes;
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        int parent, child;

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            nodes = new HashMap<Integer, Integer>();
            parentList = new ArrayList<Integer>();

            for(int j=0; j<N-1; j++) {
                st = new StringTokenizer(br.readLine());
                parent = Integer.parseInt(st.nextToken());
                child = Integer.parseInt(st.nextToken());

                if(!nodes.containsKey(parent)) {
                    nodes.put(parent, -1);
                }

                if(!nodes.containsKey(child)) {
                    nodes.put(child, parent);
                }
                else {
                    nodes.replace(child, -1, parent);
                }
            }
            st = new StringTokenizer(br.readLine());
            targetA = Integer.parseInt(st.nextToken());
            targetB = Integer.parseInt(st.nextToken());
            GetParent(targetA);
            CompareParent(targetB);
        }
        for(int s : answerList) {
            System.out.println(s);
        }
    }

    public static void GetParent(int A) {
        parentList.add(A);
        int parentA = nodes.get(A);
        if(parentA != -1) {
            GetParent(parentA);
        }
    }

    public static void CompareParent(int B) {
        if(parentList.contains(B)) {
            answerList.add(B);
            return;
        }
        CompareParent(nodes.get(B));
    }
}
