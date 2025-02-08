import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int testCases = Integer.parseInt(str);
        long sum=0;

        for(int t=0;t<testCases;t++){
            sum = 0;
            str = br.readLine();
            int day = Integer.parseInt(str);
            int []date = new int[day];

            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            for(int d=0;d<day;d++){
                date[d] = Integer.parseInt(st.nextToken());
            }
            
            int max = date[day-1];
            for(int i=day-2;i>=0;i--){
                if(date[i]<=max){
                    sum += max-date[i];
                }
                else if(date[i]>max){
                    max = date[i];
                }
            }

            System.out.println(sum);
        }
    }
}