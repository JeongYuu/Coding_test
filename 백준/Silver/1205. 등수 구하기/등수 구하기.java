import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] score = new int[n];
        
        if(n == 0){
            System.out.println("1");
        }
        else {
            str = br.readLine();
            st = new StringTokenizer(str," ");

            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }

            if (n == p && score[p - 1] >= newScore) {
                System.out.println("-1");
            } else {
                int grade = 1;
                for (int i = 0; i < n; i++) {
                    if (score[i] > newScore) {
                        grade++;
                    } else {
                        break;
                    }
                }
                System.out.println(grade);
            }
        }
    }
}