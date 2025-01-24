import java.io.*;
import java.util.*;

public class Main {
    static int []dicX = {0,0,1,-1};
    static int []dicY = {1,-1,0,0};
    static int[][] list;
    static int[][] visited;
    static int h,w,nowX,nowY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        list = new int[h][w];
        visited = new int[h][w];
        for(int i=0;i<h;i++){
            str = br.readLine();
            int j = 0;
            for(char ch : str.toCharArray()) {
                list[i][j] = Integer.parseInt(String.valueOf(ch));
                j++;
            }
        }

        bfs(0,0);

        System.out.println(list[h-1][w-1]);


    }
    static void bfs(int x, int y){
        Queue <int[]> que = new LinkedList<>();

        que.add(new int[]{x,y});
        while(!que.isEmpty()) {
            int[]tmp = que.poll();
            for (int i = 0; i < 4; i++) {
                nowX = tmp[0] + dicX[i];
                nowY = tmp[1] + dicY[i];

                if(checking(nowX,nowY) && visited[nowX][nowY] == 0 && list[nowX][nowY]==1){
                    visited[nowX][nowY] = 1;
                    que.add(new int[]{nowX,nowY});
                    list[nowX][nowY] = list[tmp[0]][tmp[1]]+1;
                }
            }
        }
    }

    static boolean checking(int x, int y){
        return (x>=0 && x<h && y>=0 && y<w);
    }
}