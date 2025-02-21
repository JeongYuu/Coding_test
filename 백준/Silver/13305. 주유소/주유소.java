import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int N = Integer.parseInt(str);
        int[] km = new int[N-1];
        int[] city = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i=0;i<N-1;i++) {
            km[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i=0;i<N;i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long min = city[0];
        long answer = 0;

        for(int i=0;i<N-1;i++){
            if(min>city[i]) min = city[i];
            answer += min*km[i];
        }
        System.out.println(answer);
    }
}
