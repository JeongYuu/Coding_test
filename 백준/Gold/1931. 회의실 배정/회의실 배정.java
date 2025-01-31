import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        int[][] list = new int[n][2];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        int finish = 0;
        int answer = 0;

        for(int i=0;i<n;i++){
            if(finish <= list[i][0]){
                finish = list[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}