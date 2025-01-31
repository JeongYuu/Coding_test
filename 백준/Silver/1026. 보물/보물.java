import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int n = Integer.parseInt(str);
        int [] A = new int[n];
        int [] B = new int[n];
        int sum = 0;
        
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i=0;i<n;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0;i<n;i++){
            sum+= A[n-i-1]*B[i];
        }
        
        System.out.println(sum);
    }
}