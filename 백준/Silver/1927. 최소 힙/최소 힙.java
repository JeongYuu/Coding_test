import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while(N-- != 0){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                System.out.println(pq.size()==0?"0":pq.poll());
            }
            else{
                pq.add(num);
            }
        }
    }
}