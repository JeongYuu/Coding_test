import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) { 
            System.out.println("1");
        } else {
            long[] scores = new long[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                scores[i] = Long.parseLong(st.nextToken());
            }

            // 리스트 크기가 `p`개를 꽉 채운 상태에서 마지막 점수보다 작거나 같으면 `-1` 출력
            if (n == p && scores[n - 1] >= newScore) {
                System.out.println("-1");
            } else {
                // 새로운 점수의 랭킹 계산
                int rank = 1;
                for (int i = 0; i < n; i++) {
                    if (scores[i] > newScore) {
                        rank++;
                    } else {
                        break;
                    }
                }
                System.out.println(rank);
            }
        }
    }
}
