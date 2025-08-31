import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left_data, right_data;

    Node(int num) {
        this.data = num;
    }

    Node(int num, Node left, Node right) {
        this.data = num;
        this.left_data = left;
        this.right_data = right;
    }

    void insert(int n) {
        if (n < this.data) {
            if (this.left_data == null)
                this.left_data = new Node(n);
            else this.left_data.insert(n);
        } else {
            if (this.right_data == null)
                this.right_data = new Node(n);
            else this.right_data.insert(n);
        }
    }
}

public class Main {
    public static void print(Node node){
        if(node != null){
            if(node.left_data != null) print(node.left_data);
            if(node.right_data != null) print(node.right_data);
            System.out.println(node.data);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        print(root);
    }
}