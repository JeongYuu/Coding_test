import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while(queue.size()!=1){
            queue.remove();
            int tempt = 0;
            tempt = queue.peek();
            queue.remove();
            queue.add(tempt);
        }
        System.out.println(queue.remove());
    }
}