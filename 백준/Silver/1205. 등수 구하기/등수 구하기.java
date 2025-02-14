import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println("1");
            return;
        }

        ArrayList<Long> scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            scores.add(Long.parseLong(st.nextToken()));
        }

        // 리스트 정렬 (내림차순)
        Collections.sort(scores, Collections.reverseOrder());

        // 리스트 크기가 랭킹 제한을 넘어서면 마지막 요소를 삭제
        if (n == p && scores.get(n - 1) >= newScore) {
            System.out.println("-1");
            return;
        }

        // 새로운 점수의 랭킹 계산
        int rank = 1;
        for (long score : scores) {
            if (score > newScore) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
    }
}
