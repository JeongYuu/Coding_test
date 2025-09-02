import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);
       
        if(num == 4 || num == 7) {
            System.out.println(-1);
            return;
        }
        
        int [] num35 = new int[2];
        num35[0] = 5;
        num35[1] = 3;

        int answer = 0;

        for(int n:num35){
            while(num > 0){
                num = num-n;
                answer++;
                if(num == 0){
                    break;
                }
                if(num == 1 || num == 2 || num == 4 || num == 7 || num < 0){
                    num=num+n;
                    answer--;
                    break;
                }
            }
            if(num == 0) {
                System.out.println(answer);
                return;
            }
        }
    }
}