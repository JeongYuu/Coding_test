import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int max = 0;
        int n = Integer.parseInt(str);
        int[] rope = new int[n];

        for(int i=0;i<n;i++){
            str = br.readLine();
            rope[i] = Integer.parseInt(str);
        }

        Arrays.sort(rope);

        for(int i=0;i<n;i++){
            if(max < rope[i]*(n-i)){
                max = rope[i]*(n-i);
            }
        }

        System.out.println(max);
    }
}