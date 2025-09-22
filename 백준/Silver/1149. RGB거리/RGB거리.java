import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int prevR = 0, prevG = 0, prevB = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int curR = r + Math.min(prevG, prevB);
            int curG = g + Math.min(prevR, prevB);
            int curB = b + Math.min(prevR, prevG);

            prevR = curR;
            prevG = curG;
            prevB = curB;
        }

        int answer = Math.min(prevR, Math.min(prevG, prevB));
        System.out.println(answer);
    }
}
