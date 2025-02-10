import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] triangle = new int[3];
        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            for(int i=0;i<3;i++){
                triangle[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(triangle);

            int a = triangle[0];
            int b = triangle[1];
            int c = triangle[2];

            if(a==0 && b==0 && c==0) break;
            else if(a==b && b==c) {
                System.out.println("Equilateral");
            }
            else if(c >= a+b){
                System.out.println("Invalid");
            }
            else if(a!=b && b!=c && a!=c){
                System.out.println("Scalene");
            }
            else{
                System.out.println("Isosceles");
            }
        }
    }
}