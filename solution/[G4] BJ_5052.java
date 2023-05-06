import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean checking = false;

            TrieNode tri = new TrieNode();
            
            for (int i = 0; i < N; i++) {
                String tempNum = br.readLine();
                if (checking) continue;
                if (tri.check(tempNum)) {
                    checking = true;
                } else {
                    tri.insert(tempNum);
                }
            }
            
            if (checking) {
                bw.write("NO" + "\n");
            } else {
                bw.write("YES" + "\n");
            }
        }

        bw.flush();
    }
    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;

        TrieNode() {
        }

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                // tmp childNode에 c없으면 추가
                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);

                // 마지막 문자 terminal
                if (i == word.length() - 1) {
                    trieNode.terminal = true;
                    return;
                }
            }
        }

        public boolean check(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);

                if (node == null) {
                    if(trieNode.terminal == true)
                        return true;
                    else 
                        return false;
                }
                trieNode = node;
            }
            return true;
        }
    }

}





