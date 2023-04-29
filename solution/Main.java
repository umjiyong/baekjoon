import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Tree tree = new Tree();
        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            tree.add(st.nextToken().charAt(0),st.nextToken().charAt(0),st.nextToken().charAt(0));

        }
            tree.printOrder();
        bw.flush();

    }

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        void add(char data, char leftData, char rightData) {
            if (root == null) {
                root = new Node(data);
                if (leftData != '.') root.left = new Node(leftData);
                if (rightData != '.') root.right = new Node(rightData);
            } else search(root, data, leftData, rightData); // 들어갈 자리를 찾아주자
        }

        void search(Node curNode, char data, char leftData, char rightData) {
            if (curNode == null) return;
            else if(curNode.data == data){
                if (leftData != '.') curNode.left = new Node(leftData);
                if (rightData != '.') curNode.right = new Node(rightData);
            }
            else{
                search(curNode.left, data, leftData, rightData);
                search(curNode.right, data, leftData, rightData);
            }
        }

        void printOrder() throws IOException {
            printPreOrder(root);
            bw.newLine();
            printInOrder(root);
            bw.newLine();
            printPostOrder(root);
            bw.newLine();
        }

        void printPostOrder(Node node) throws IOException {
            if (node == null)
                return;

            printPostOrder(node.left);
            printPostOrder(node.right);
            bw.write(node.data);
        }

        void printPreOrder(Node node) throws IOException {
            if (node == null)
                return;

            bw.write(node.data);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }

        void printInOrder(Node node) throws IOException {
            if (node == null)
                return;

            printInOrder(node.left);
            bw.write(node.data);
            printInOrder(node.right);
        }

    }
}