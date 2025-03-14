import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            int value = Integer.parseInt(br.readLine());
            int idx = binarySearch(power, value);
            sb.append(names[idx]).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] power, int value) {
        int left = 0, right = power.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (power[mid] >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
