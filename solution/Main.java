import java.io.*;
import java.util.*;

public class Main {
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = " ";
        Tree tree = new Tree();

        while(true){
            in = br.readLine();
            if (in == null){
                break;
            }
            int now = Integer.parseInt(in);

            tree.addNode(now);
        }
        tree.printPostOrder();
        bw.flush();


    }
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Tree {
        Node root;

        void addNode(int value){
            if (root==null){
                root = new Node(value);
            }
            else{
                addNode(root,value);
            }
        }

        void addNode(Node node, int value){
            if (node == null){
                return;
            }
            if (node.value < value){
                if(node.right==null){
                    node.right = new Node(value);
                }
                else {
                    addNode(node.right,value);
                }
            }
            else {
                if (node.left==null){
                    node.left = new Node(value);
                }
                else {
                    addNode(node.left,value);
                }
            }
        }

        void printPostOrder() throws IOException {
            printPostOrder(root);
        }

        void printPostOrder(Node node) throws IOException {
            if (node == null)
                return;

            printPostOrder(node.left);
            printPostOrder(node.right);
            bw.write(node.value+"\n");
        }

    }
}







