import java.util.*;
import java.io.*;

public class Main {
    static int[][] visited;
    static int[][] list;
    static int []dicX ={0,0,1,-1};
    static int []dicY ={1,-1,0,0};
    static int h,w,nowX, nowY;
    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        list = new int[h][w];
        visited = new int[h][w];
        for(int i=0;i<h;i++){
            str = br.readLine();
            st = new StringTokenizer(str," ");
            for(int j=0;j<w;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(visited[i][j] == 0 && list[i][j] == 1) {
                    count++;
                    sum = 0;
                    dfs(i, j);
                    if(max < sum) max = sum;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);


    }
    static void dfs(int  i, int j){
        sum++;
        visited[i][j] = 1;

        for(int n=0;n<dicX.length;n++){
            nowX = i + dicX[n];
            nowY = j + dicY[n];
            if (checking(nowX,nowY)&& visited[nowX][nowY] == 0 && list[nowX][nowY] == 1) {
                dfs(nowX, nowY);
            }
        }
    }

    static boolean checking(int x, int y){
        return (x >=0 && x < h && y >=0 && y < w);
    }
}