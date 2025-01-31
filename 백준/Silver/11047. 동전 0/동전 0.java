import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int change;
        int answer = 0;
        int index = n-1;
        int [] value = new int[n];

        for(int i=0;i<n;i++){
            str = br.readLine();
            value[i] = Integer.parseInt(str);
        }

        for(int i=n-1;i>=0;i--){
            if(value[i] <= sum){
                index = i;
                break;
            }
        }

        for(int i=index;i>=0;i--){
            int num = sum / value[i];
            change = sum - (value[i] * num);
            answer += num;
            sum = change;

            if(sum == 0){
                System.out.println(answer);
                break;
            }
        }

    }
}