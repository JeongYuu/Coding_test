import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int start, end,length;
    static int[] visited;
    static int[] hide;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if(start <= end) {
            length = end + 2;

            visited = new int[length];
            hide = new int[length];

            list = new ArrayList[length];
            for (int i = 0; i < length; i++) {
                list[i] = new ArrayList<>();

                int n = i;
                list[i].add(n - 1);
                list[i].add(n + 1);
                list[i].add(n * 2);
            }

            queue.offer(start);

            bfs();
            System.out.println(hide[length - 2]);
        }
        else{
            System.out.println(start-end);
        }
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int num = queue.poll();
            visited[num]=1;

            for(int j=0;j<list[num].size();j++) {
                int tmp = list[num].get(j);
                if(checking(tmp) && visited[tmp]==0 &&hide[tmp]==0){
                    hide[tmp] = hide[num]+1;
                    queue.offer(tmp);
                }
            }


        }
    }
    static boolean checking(int x){
        return (x>=0 && x<length);
    }
}