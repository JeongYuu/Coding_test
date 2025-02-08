import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue <>();

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0;i<m;i++){
            long a = pq.poll();
            long b = pq.poll();
            long abSum = a+b;
            pq.add(abSum);
            pq.add(abSum);
        }

        long sum = 0;
        for(Long i:pq){
            sum += i;
        }

        System.out.println(sum);
    }
}