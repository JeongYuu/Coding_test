import java.io.*;
import java.util.*;

public class Main {
    static int [][][] tomato;
    static int m,n,h;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][m][n];

        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                str = br.readLine();
                st = new StringTokenizer(str," ");
                for(int k=0;k<n;k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k]==1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        int answer = bfs();

        if(answer == -1) {
            System.out.println("-1");
        }
        else{
            System.out.println(answer-1);
        }

    }

    static int bfs(){
        int[] dicZ = {1,-1,0,0,0,0};
        int[] dicX = {0,0,0,0,1,-1};
        int[] dicY = {0,0,1,-1,0,0};
        int nowX,nowY,nowZ;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            for(int i=0;i<6;i++){
                nowZ = tmp[0] + dicZ[i];
                nowX = tmp[1] + dicX[i];
                nowY = tmp[2] + dicY[i];

                if(checking(nowZ,nowX,nowY) && tomato[nowZ][nowX][nowY]==0){
                    tomato[nowZ][nowX][nowY] = tomato[tmp[0]][tmp[1]][tmp[2]]+1;
                    queue.offer(new int[]{nowZ,nowX,nowY});
                }
            }
        }
        int max = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(tomato[i][j][k]==0) {
                        return -1;
                    }
                    else{
                        max = Math.max(max, tomato[i][j][k]);
                    }
                }
            }
        }
        return max;
    }

    static boolean checking(int z, int x, int y){
        return (z>=0 && z<h && x>=0 && x<m && y>=0 && y<n);
    }
}