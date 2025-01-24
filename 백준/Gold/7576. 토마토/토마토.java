import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static int M, N;
    static int[] dX = {0, 0, 1, -1};
    static int[] dY = {1, -1, 0, 0};
    static int[][] days;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        days = new int[N][M];

        for (int m = 0; m < N; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < M; n++) {
                days[m][n] = Integer.parseInt(st.nextToken());
                if (days[m][n] == 1) {
                    queue.add(new int[]{m, n});
                }
            }
        }
        System.out.println(BFS());
    }

    private static int BFS() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            int nX = 0;
            int nY = 0;
            //(queue.poll()[0],queue.poll()[1])
            for (int i = 0; i < 4; i++) {
                nX = x + dX[i];
                nY = y + dY[i];

                if (checking(nX, nY) && days[nX][nY] == 0) {
                    days[nX][nY] = days[x][y]+1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }

        for (int m = 0; m < N; m++) {
            for (int n = 0; n < M; n++) {
                if (days[m][n] == 0) {
                    return -1;
                }
                count = Math.max(count, days[m][n]);
            }
        }
        if (count == 1) {
            return 0;
        } else {
            return count - 1;
        }
    }
        private static boolean checking ( int x, int y){
        return (x < N && x >= 0 && y >= 0 && y < M);
    }
}