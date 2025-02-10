import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int j=0; j<n;j++){
            ArrayList<int[]> queue = new ArrayList<>();
            ArrayList<int[]> result = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                int a = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i,a});
            }

            int count =0;
            while(!queue.isEmpty()){
                count = 0;
                for (int x = 0; x < queue.size(); x++) {

                    if (queue.get(0)[1] < queue.get(x)[1]) {

                        queue.add(queue.get(0));
                        queue.remove(0);
                        count++;
                        break;
                    }
                    else{count++;}

                    if(count == queue.size()){
                        result.add(new int[]{queue.get(0)[0],queue.get(0)[1]});
                        queue.remove(0);
                    }

                }

            }

            for(int i=0;i<N;i++){
                //System.out.println(result.get(i)[0]+" "+result.get(i)[1]);
                if(result.get(i)[0] == M){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}