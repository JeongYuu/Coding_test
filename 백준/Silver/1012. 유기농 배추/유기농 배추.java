import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[][] list;
    static int[][] visited;
    static int []dirX = {0,0,1,-1};
    static int []dirY = {1,-1,0,0};
    static int nowX, nowY;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int re = Integer.parseInt(str);

        for(int r = 0;r<re;r++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            int bug = Integer.parseInt(st.nextToken());

            list = new int[h][w];
            visited = new int[h][w];

            int count = 0;

            for (int i = 0; i < bug; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int bugX = Integer.parseInt(st.nextToken());
                int bugY = Integer.parseInt(st.nextToken());
                list[bugX][bugY] = 1;
            }


            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == 0 && list[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void dfs(int i,int j){
        visited[i][j] = 1;

        for(int n=0;n<4;n++){
            nowX = i + dirX[n];
            nowY = j + dirY[n];

            if(checking(nowX,nowY) && visited[nowX][nowY]==0 && list[i][j]==1){
                dfs(nowX,nowY);
            }

        }
    }
    static boolean checking(int i,int j){
        return (i>=0 && i<h && j>=0 && j<w);
    }
}