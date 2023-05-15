import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            linkedList.add(i);
        }
        int frontValue = 1;

        st = new StringTokenizer(br.readLine());
        int count = 0;
        while (size-- > 0) {
            int toFindNum = Integer.parseInt(st.nextToken());

            while (toFindNum != frontValue) { // 2번 3번 로직 수행
                int nowIndex = linkedList.indexOf(toFindNum); // 바뀐 인덱스 값
                int nowSize = linkedList.size();
                if (nowIndex < nowSize - nowIndex) { // front 와의 거리가 더 가깝다면
                    linkedList.addLast(linkedList.removeFirst());
                } else { // back과의 거리가 같거나 크다면
                    linkedList.addFirst(linkedList.removeLast());
                }
                frontValue = linkedList.getFirst();
                count++;
            }

            linkedList.removeFirst();
            if (linkedList.isEmpty()) break;
            frontValue = linkedList.getFirst();
        }
        System.out.println(count);
    }
}
